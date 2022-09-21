package br.com.bcbrito.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bcbrito.microservice.loja.client.FornecedorClient;
import br.com.bcbrito.microservice.loja.dto.CompraDTO;
import br.com.bcbrito.microservice.loja.dto.InfoPedidoDTO;
import br.com.bcbrito.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {

		final String estado = compra.getEndereco().getEstado();
		
		LOG.info("buscando informações do fornecedor de {}", estado);
		fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
				
		LOG.info("realizando pedido dos itens");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;

	}

}

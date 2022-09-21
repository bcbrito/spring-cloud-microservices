package br.com.bcbrito.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.bcbrito.microservice.loja.client.FornecedorClient;
import br.com.bcbrito.microservice.loja.dto.CompraDTO;
import br.com.bcbrito.microservice.loja.dto.InfoFornecedorDTO;
import br.com.bcbrito.microservice.loja.dto.InfoPedidoDTO;
import br.com.bcbrito.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {

		//Para testar o funcionamento do obter informações do Fornecedor por estado
		InfoFornecedorDTO info =  fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		System.out.println(info.getEndereco());
		
		// Implementado o método para realizar a compra do pedido
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		//Preparando objeto para retornar a compra salva
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;

	}

}

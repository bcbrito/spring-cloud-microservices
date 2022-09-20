package br.com.bcbrito.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.bcbrito.microservice.loja.client.FornecedorClient;
import br.com.bcbrito.microservice.loja.dto.CompraDTO;
import br.com.bcbrito.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public void realizaCompra(CompraDTO compra) {

		InfoFornecedorDTO info =  fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		System.out.println(info.getEndereço());
	}

}

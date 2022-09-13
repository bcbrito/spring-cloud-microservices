package br.com.bcbrito.microservice.loja.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bcbrito.microservice.loja.controller.dto.CompraDTO;
import br.com.bcbrito.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	public void realizaCompra(CompraDTO compra) {

		RestTemplate client = new RestTemplate();
		ResponseEntity<InfoFornecedorDTO> exchange =  client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDTO.class);

		System.out.println(exchange.getBody().getEndereço());
	}

}

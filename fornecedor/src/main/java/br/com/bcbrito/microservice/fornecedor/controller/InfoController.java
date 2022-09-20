package br.com.bcbrito.microservice.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bcbrito.microservice.fornecedor.model.InfoFornecedor;
import br.com.bcbrito.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private InfoService infoservice;
	
	@RequestMapping("/{estado}")
	public InfoFornecedor GetInfoPorEstado(@PathVariable String estado) {
		return infoservice.getInfoPorEstado(estado);
	}
}

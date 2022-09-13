package br.com.bcbrito.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bcbrito.fornecedor.service.InfoService;

@RestController
@RequestMapping("/Info")
public class InfoController {

	@Autowired
	private InfoService infoservice;
	
	@RequestMapping("/{estado}")
	public void GetInfoPorEstado(String estado) {
		infoservice.getInfoPorEstado(estado);
	}
}

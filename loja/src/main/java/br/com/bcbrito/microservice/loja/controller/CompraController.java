package br.com.bcbrito.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bcbrito.microservice.loja.dto.CompraDTO;
import br.com.bcbrito.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String realizaCompra(@RequestBody CompraDTO compra) 
	{		
		compraService.realizaCompra(compra);
		return "Compra realizada com Sucesso!";
	}
}

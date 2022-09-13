package br.com.bcbrito.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;

	public void getInfoPorEstado(String estado) {
		// TODO Auto-generated method stub
		
	}

}

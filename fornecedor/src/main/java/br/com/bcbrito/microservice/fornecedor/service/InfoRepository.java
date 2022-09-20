package br.com.bcbrito.microservice.fornecedor.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bcbrito.microservice.fornecedor.model.InfoFornecedor;

@Repository
public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
	
	InfoFornecedor findByEstado(String estado);

}

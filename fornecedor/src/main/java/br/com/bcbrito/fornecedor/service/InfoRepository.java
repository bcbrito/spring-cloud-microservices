package br.com.bcbrito.fornecedor.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bcbrito.fornecedor.model.InfoFornecedor;

@Repository
public interface InfoRepository extends CrudRepository<InfoFornecedor, Long> {
	
	InfoFornecedor findByEstado(String estado);

}

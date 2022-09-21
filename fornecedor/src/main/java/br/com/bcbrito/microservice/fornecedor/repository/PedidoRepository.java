package br.com.bcbrito.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bcbrito.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}

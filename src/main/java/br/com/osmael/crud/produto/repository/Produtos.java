package br.com.osmael.crud.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.osmael.crud.produto.entity.Produto;

public interface Produtos extends JpaRepository<Produto, Long>{
	
}
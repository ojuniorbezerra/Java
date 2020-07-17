package com.envies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.envies.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	   public Produto findByid(Long id);
	   public Produto findBySku(String sku);
}

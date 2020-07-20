package com.envies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.envies.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Categoria findByNome(String nome);

}

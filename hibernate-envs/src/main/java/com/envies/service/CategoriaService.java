package com.envies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envies.model.Categoria;
import com.envies.repository.CategoriaRepository;

@Service
public class CategoriaService {

	private CategoriaRepository categoriaRepository;

	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}
	
	public Categoria findById(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}
	
	public Categoria findByNome(String nome) {
		return categoriaRepository.findByNome(nome);
	}
	
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
}

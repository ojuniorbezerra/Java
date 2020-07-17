package com.envies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envies.model.Produto;
import com.envies.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	
	public Produto findByid(Long id) {
		return produtoRepository.findByid(id);
	}
	 public Produto findBySku(String sku){
	        return produtoRepository.findBySku(sku);
    }
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }
}

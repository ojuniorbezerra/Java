package com.envies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.envies.model.Categoria;
import com.envies.model.Produto;
import com.envies.service.CategoriaService;
import com.envies.service.ProdutoService;

@Controller
@RequestMapping("/api/categoria")
public class CategoriaController {

	private CategoriaService categoriaService;
	private ProdutoService produtoService;
	
	@Autowired
	public CategoriaController(CategoriaService categoriaService, ProdutoService produtoService) {
		super();
		this.categoriaService = categoriaService;
		this.produtoService = produtoService;
	}
	 

    @RequestMapping(value = "/novaCategoria", method = RequestMethod.POST)
    public ResponseEntity<Categoria> novaCategoria(@RequestBody Categoria categoria) {
        Categoria cat = categoriaService.findByNome(categoria.getNome());
        if(cat != null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Categoria>(categoriaService.save(categoria), HttpStatus.OK);
    }

    @RequestMapping(value = "/adicionaProduto/{sku}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> adicionaProduto(@PathVariable String sku, @RequestBody Categoria categoria) {
        Produto produto = produtoService.findBySku(sku);
        Categoria cat = categoriaService.findByNome(categoria.getNome());
        cat.getProdutos().add(produto);
        categoriaService.save(cat);
        return new ResponseEntity<Categoria>(cat, HttpStatus.OK);
    }

    @RequestMapping(value = "/removeProduto/{sku}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> removeProduto(@PathVariable String sku, @RequestBody Categoria categoria) {
        Produto produto = produtoService.findBySku(sku);
        Categoria cat = categoriaService.findByNome(categoria.getNome());
        cat.getProdutos().remove(produto);
        categoriaService.save(cat);
        return new ResponseEntity<Categoria>(cat, HttpStatus.OK);
    }

    @RequestMapping("/{nome}")
    public ResponseEntity<Categoria> consulta(@PathVariable String nome) {
        Categoria cat = categoriaService.findByNome(nome);
        if(cat != null)
            return new ResponseEntity<Categoria>(cat, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	
	
}

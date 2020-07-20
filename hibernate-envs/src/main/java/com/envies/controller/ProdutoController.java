package com.envies.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.envies.model.Produto;
import com.envies.service.ProdutoService;

@Controller
@RequestMapping("/api/produtos")
public class ProdutoController {

	private ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
		Produto pReturn = produtoService.save(produto);
		if (Objects.isNull(pReturn)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Produto>(pReturn, HttpStatus.OK);	
		}
	}
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> listAll(){
		return new ResponseEntity<List<Produto>>(produtoService.findAll(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/alteraEstoque", method = RequestMethod.PUT)
    public ResponseEntity<Produto> alteraEstoque(@RequestBody Produto produto) {
        Produto produtoObject = produtoService.findBySku(produto.getSku());
        if(produto.getEstoque() != null)
            produtoObject.setEstoque(produto.getEstoque());
        return new ResponseEntity<Produto>(produtoService.save(produtoObject), HttpStatus.OK);
    }
	

    @RequestMapping(value = "/alteraPreco", method = RequestMethod.PUT)
    public ResponseEntity<Produto> alteraPreco(@RequestBody Produto produto) {
        Produto produtoObject = produtoService.findBySku(produto.getSku());
        if(produto.getPreco() != null)
            produtoObject.setPreco(produto.getPreco());
        return new ResponseEntity<Produto>(produtoService.save(produtoObject), HttpStatus.OK);
    }

    @RequestMapping(value = "/{sku}", method = RequestMethod.GET)
    public ResponseEntity<Produto> consulta(@PathVariable String sku) {
        Produto p = produtoService.findBySku(sku);
        if(p != null)
            return new ResponseEntity<Produto>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
}

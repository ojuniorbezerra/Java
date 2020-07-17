package com.envies.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_produto")
public class Produto {
	
	private Long id;
	
	private String nome;
	
	private String sku;
	
	private Integer estoque;
	
	private Double preco;
}

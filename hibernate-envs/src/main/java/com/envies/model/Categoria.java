package com.envies.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sq_categoria")
	@SequenceGenerator(name = "sq_categoria", sequenceName = "CATEGORIA_SEQ")
	private Long id;
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "categoria_produto")
	private List<Produto> produtos;
}


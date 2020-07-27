package com.envies.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Data;

@Entity
@Data
@Audited
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "sq_produto")
	@SequenceGenerator(name = "sq_produto", sequenceName = "PRODUTO_SEQ")
	private Long id;
	
	private String nome;
	
	@Column(unique=true)
	private String sku;
	
	private Integer estoque;
	
	private Double preco;
}

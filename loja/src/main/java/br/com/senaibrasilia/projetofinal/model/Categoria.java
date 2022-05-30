package br.com.senaibrasilia.projetofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * O que é uma Enum? 
 * 
 * Conjunto do Constantes
 * 
 * Public enum EUtil{
  	PI,
  	XTUDO,
  	PODRAO
  	BOMBA,
  	BIGMAC
  }
 * 
 */

@Entity
@Table(name="categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	public Categoria() {
		super();
	}
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}








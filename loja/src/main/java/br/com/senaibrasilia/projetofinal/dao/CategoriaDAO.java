package br.com.senaibrasilia.projetofinal.dao;

import javax.persistence.EntityManager;


import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;

public class CategoriaDAO {

	private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		this.em =em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
		//persist
	}
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
		
		//merge
	}
	public void remover(Categoria categoria) {
		categoria = em.merge(categoria);
		this.em.remove(categoria);
	}
	
	
	/*public void buscarPorID(Categoria categoria) {
		this.em.find(Produto.class, categoria);
		//find
	}*/
	
	public Categoria buscarPorID(int id) {
		return em.find(Categoria.class, id);
	}
	public void buscarTodos() {
		//query - JPQL
		//ArrayList - List
		//Lambda - Java 8
	}


}



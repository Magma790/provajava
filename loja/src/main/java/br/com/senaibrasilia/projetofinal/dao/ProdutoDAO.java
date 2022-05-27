package br.com.senaibrasilia.projetofinal.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.model.Produto;

public class ProdutoDAO {

	private EntityManager em;
	
	public ProdutoDAO(EntityManager em2) {
		// TODO Auto-generated constructor stub
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto);
		}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
		//merge
	}
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscarPorId(int i) {
			return em.find(Produto.class, i);
		//find
	}
	public List<Produto> buscarTodos() {
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();	
	}
	public List<Produto> buscarPorNome(String nome) {
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome",nome)
				.getResultList();
	//?
	}
	public List<Produto> buscarPorNomeDaCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
				
	}

	public BigDecimal buscarPreçoDoProdutoComNome(String string) {
		// TODO Auto-generated method stub
		return null;
	}

//Proud

}

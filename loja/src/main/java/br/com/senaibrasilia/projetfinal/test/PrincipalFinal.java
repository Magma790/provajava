package br.com.senaibrasilia.projetfinal.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.senaibrasilia.projetofinal.dao.CategoriaDAO;
import br.com.senaibrasilia.projetofinal.dao.ProdutoDAO;
import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.model.Produto;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

public class PrincipalFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	cadastrarProduto();
	//EntityManager em = JPAUtil.getEntityManager();
	//ProdutoDAO produtoDAO = new ProdutoDAO(em);
	
	//Produto p = produtoDAO.buscarPorId(11);
	//System.out.println(p.getPreco());
	
	//List<Produto> todos = 
	//		produtoDAO.buscarPorNomeDaCategoria("INFORMÁTICA");
	//			todos.forEach(p2 -> System.out.println(p.getNome()));

	//BigDecimal precoDoProduto = produtoDAO.buscarPreçoDoProdutoComNome("Gabinete TGT");
	//System.out.println("Preço do Produto: "+precoDoProduto);
	}

	private static void cadastrarProduto() {
		// TODO Auto-generated method stub
	Categoria informatica = new Categoria( "INFORMÁTICA");
	Produto gabinete = new Produto ("Gabinete TGT", "COR: PRETO /nRGB:SIM", new BigDecimal("500"), informatica);
	
	EntityManager em = JPAUtil.getEntityManager();
	ProdutoDAO produtoDAO = new ProdutoDAO (em);
	CategoriaDAO categoriaDAO = new CategoriaDAO(em);
	
	em.getTransaction().begin();
	
	//categoriaDAO.cadastrar(informatica);
	//produtoDAO.cadastrar(gabinete);
	em.persist(informatica);
	em.persist(gabinete);
	
	em.getTransaction().commit();
	em.close();
		
	
	
	
	
	
	
	}

}

//Passo 1- verificar se inseriu o pacote corretamente

package br.com.senaibrasilia.projetofinal.viewswing;

//Passo 2- Verificar se o aluno importou os seguintes pacotes:

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.swing.*;

import br.com.senaibrasilia.projetofinal.dao.CategoriaDAO;
import br.com.senaibrasilia.projetofinal.model.Categoria;
import br.com.senaibrasilia.projetofinal.util.JPAUtil;

//Passo 3-Verificar se implementou ActionListener


public class FormCadCategoria implements ActionListener {
     
	//Passo 4 - Verificar se o aluno cirou um JTextField
	private JTextField txtCategoria;
	private JTextField txtCategoriaId;
	//Passo 4.1 - Verificar se adicionou um JLabel
	private JLabel lblCategoria = new JLabel("Categoria:");
	private JLabel lblCategoriaId = new JLabel("Categoria Id:");
	//Passo 4.2 - Verificar se criou um bot�o
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JButton btnBuscarId = new JButton("Buscar Id");
	private JButton btnAtualizar = new JButton("Atualizar/Merge");
	//Passo 4.3 - Verificar se criou um JList,JLabel e JScrollPane
	
	//Passo 4.4 - Verificar se criou uma collection List
	//Para isso chame primeiramente o EntityManager
	EntityManager em = JPAUtil.getEntityManager();
	
	//Passo 5 - Verificar se o aluno iniciou o construtor
	public FormCadCategoria() {
		
		//Passo 6 - Verificar se inst�nciou o JFrame
		JFrame frmCategoria = new JFrame("Escola Java- SENAI Bras�lia");
		
		//Passo 6.1 - Verificar se inst�nciou o JTextField
		txtCategoria = new JTextField(30);
		txtCategoriaId = new JTextField(30);
				
		
		//Passo 7 - Verificar se setou o gerenciador de layout FlowLayout ou similar
		frmCategoria.setLayout(new FlowLayout());
		
		//Passo 8 - Verificar se fornece um tamanho inicial para o frame
		frmCategoria.setSize(700,200);
		
		//Passo 8.1 - Verificar se adicionou comandos de a��o
		btnCadastrar.setActionCommand("cadastrar");
		btnBuscarId.setActionCommand("buscarId");
		btnAtualizar.setActionCommand("atualizar");
		
		//Passo 8.1 Verificar se adiciona o evento ao bot�o (ouvinte)
		btnCadastrar.addActionListener(this);
		btnBuscarId.addActionListener(this);
		btnAtualizar.addActionListener(this);
		//Verificar se adiciona os componentes ao container
		frmCategoria.add(lblCategoria);
		frmCategoria.add(txtCategoria);
		frmCategoria.add(btnCadastrar);
		frmCategoria.add(lblCategoriaId);
		frmCategoria.add(txtCategoriaId);
		frmCategoria.add(btnBuscarId);
		frmCategoria.add(btnAtualizar);
		
		//Passo 9 - Verificar se o aluno programou o encerramento do programa quando o usu�rio fecha o aplicativo
		frmCategoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Passo 9.1 Verificar se adicionou um c�digo para centralizar
		frmCategoria.setLocationRelativeTo(null);
		
		
		
		
		 
	
		 
	
		
		//Passo 9.2 Verificar se Adicionou a visibilidade do Frame 
		frmCategoria.setVisible(true);
	}
	
	//Passo 3.1 - Verificar se o m�todo actionPerfomed da Interface ActionListener foi implementada com override (sobrescrita) o verdadeiro polimorfismo segundo especialistas mundiais Java.
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Categoria c = new Categoria();
		if(e.getActionCommand().equals("cadastrar")) {
			JOptionPane.showMessageDialog(null, "Vai sair de Transient para Managed");
			
		
			if(c.getId() == 0) {
				CategoriaDAO cDao = new CategoriaDAO(em);		
				em.getTransaction().begin();
				c.setNome(txtCategoria.getText());
			    cDao.cadastrar(c);
			    em.flush();		  		    
			    txtCategoria.setText(""); 
			    em.clear();
				
			}
			
		 
		    
			
		}else if(e.getActionCommand().equals("buscarId")) {
			CategoriaDAO cDao = new CategoriaDAO(em);
			int id =Integer.parseInt(txtCategoriaId.getText());
			c = cDao.buscarPorID(id);
			txtCategoria.setText(c.getNome());
		    
		}else if(e.getActionCommand().equals("atualizar")) {
			JOptionPane.showMessageDialog(null,"Atualizar em Manuten��o!");
			/*
			CategoriaDao cDao = new CategoriaDao(em);
			em.getTransaction().begin();
			em.merge(c);
			c.setNome(txtCategoria.getText());
			cDao.atualizar(c);
			em.flush();*/
			c = em.merge(c);
			
		}
	}
	

}

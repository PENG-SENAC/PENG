package com.senac.livraria.test;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONValue;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.senac.livraria.dao.LivrariaDAO;
import com.senac.livraria.model.Livro;

public class TesteLivrariaDAO {
	public static LivrariaDAO livroDAO;
	
	
	@BeforeClass
	public static void criarBanco(){
		livroDAO = new LivrariaDAO();
		Assert.assertNotNull( livroDAO );
	}
	
	@Test
	public void listarLivros(){
		List<Livro> livros = livroDAO.listarLivros();
		
		for (Livro livro : livros) {
			System.out.println( livro.toString() );
		}
		
		Assert.assertNotNull( livros );
				
	}
	
	@Test
	//@Ignore
	public void inserirLivro(){
		Livro livro = new Livro();
		System.out.println( "INSERCAO DE LIVRO" );
		livro.setId("0001");
		livro.setTitulo("Desenvolvimento com JAVA");
	    livro.setAutor("Clayton Escouper");
	    livro.setEditor("Ze Maria");
	    livro.setDataLancamento("2006-06-06");
	    
		livroDAO.inserirLivro(livro);
		
	}
	
	
	
	@Test
	@Ignore
	public void jsonObjectTeste(){
		Livro livro = new Livro();
		livro.setId("37427e5c-2997-4f1f-9194-90882a053807");
		livro.setTitulo("Cartman Gets an Anal Probe");
	    livro.setAutor("Kees van Baaren");
	    livro.setEditor("Ashfaqulla Khan");
	    livro.setDataLancamento("2003-05-26T00:25:50.756Z");
		    
	    Livro livro2 = new Livro();
	    livro2.setId("1d3dc318-2b87-4270-9be6-0bc15ee43c67");
		livro2.setTitulo("Badnjak");
	    livro2.setAutor("Sócrates");
	    livro2.setEditor("Eddie Arcaro");
	    livro2.setDataLancamento("2001-08-17T12:17:01.062Z");
		
	    List<Livro> livros = new ArrayList<Livro>();
	    livros.add(livro);
	    livros.add(livro2);
	    
		/* ### JSONValue ### */
	    System.out.println("JSONValue unico com VALUE OBJETO: " );
	    System.out.println( JSONValue.toJSONString( livro ) );
	    	    	       
	    System.out.println("JSONValue ARRAY com VALUE OBJETO: " );
	    System.out.println( JSONValue.toJSONString( livros ) );    
	    
	}
	
	
	
}

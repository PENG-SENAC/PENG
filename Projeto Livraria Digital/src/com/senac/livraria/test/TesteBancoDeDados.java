package com.senac.livraria.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.senac.livraria.dao.bancodados.BancoDeDados;
import com.senac.livraria.model.Livro;

@org.junit.FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class TesteBancoDeDados {
	public static BancoDeDados banco = null;
	
	@BeforeClass
	public static void criarNovoBanco() {
		System.out.println("### TESTE Banco de Dados ###");
		try {
			banco = new BancoDeDados("BancoTeste");
			System.out.println("Banco Criado: "+banco.getBancoFullPath() );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertNotNull( banco );
	}
	
	@Test
	public void teste01ConteudoZeroNoBanco(){
		System.out.println("Conteúdo Zero no Banco: "+ banco.listarLivros().toString() );
		
	}
	
	@Test
	public void teste02ZeroLivrosNoBanco(){
		List<Livro> livros = banco.listarLivros();		
		Assert.assertEquals(0, livros.size());
		
		System.out.println("Zero Livros no Banco: "+livros.size());
	}
	
	@Test
	public void teste03InserirConteudoNoBanco(){
		
		Livro livro = new Livro();
		livro.setId("0001");
		livro.setTitulo("Desenvolvimento com JAVA");
	    livro.setAutor("Clayton Escouper");
	    livro.setEditor("Ze Maria");
	    livro.setDataLancamento("2006-06-06");
		   
		banco.inserirLivro(livro);
		
	}
	
	@Test
	public void teste04ConteudoUmLivroEmTextoNoBanco(){
		List<Livro> livros = banco.listarLivros();
		Assert.assertNotEquals("", livros.toString());
		System.out.println("Conteúdo do Banco: "+ livros.toString() );
				
		Assert.assertNotEquals(0, livros.size());
		System.out.println("Quantidade de Livros no Banco: "+livros.size());
	}
	
	@Test
	public void teste05ApagarLivro(){
		banco.removerLivro("0001");
	}
	
	@AfterClass
	public static void ResetDeTesteApagarBanco(){
		String fullPath = banco.getBancoFullPath();
		File file = new File(fullPath);
		System.out.println("Banco Deletado: "+fullPath);
		Assert.assertTrue( file.delete() );
		System.out.print("--- Encerrando Teste ---");
	}

}

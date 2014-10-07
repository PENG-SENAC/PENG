package com.senac.livraria.bancodedados.run;

import java.util.Calendar;
import java.util.List;

import com.senac.livraria.bancodedados.dao.LivroDao;
import com.senac.livraria.bancodedados.model.Livro;

public class TesteLivrariaBancoDeDados {
	
	public static void main(String[] args) {
		//inserirLivro();
		listarLivros();
		
		
	}
	
	public static void inserirLivro(){
		Livro livro = new Livro();
		
		livro.setTitulo("PENG");
		livro.setAutor("Pipoco");
		livro.setEditora("Elsevier");
		livro.setEmail("pipoco@elsevier.com.br");
		livro.setDataLancamento(Calendar.getInstance());
		
		LivroDao dao = new LivroDao();
		dao.adiciona(livro);
	}
	
	public static void listarLivros(){
		LivroDao dao = new LivroDao();
		List<Livro> livros = dao.getLista();
		
		for (Livro livro : livros) {
			System.out.println("Titulo "+ livro.getTitulo() );
			System.out.println("Autor "+livro.getAutor() );
			System.out.println("Editora "+livro.getEditora() );
			System.out.println("Email "+livro.getEmail() );
			System.out.println("data Lancamento "+livro.getDataLancamento().getTime() );
		}
	}

}
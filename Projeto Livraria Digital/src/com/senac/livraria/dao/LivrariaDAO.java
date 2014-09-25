package com.senac.livraria.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.senac.livraria.dao.bancodados.BancoDeDados;
import com.senac.livraria.model.Livro;

public class LivrariaDAO {
	private final String nomeBanco = "Livraria_Digital_DB";
	private BancoDeDados bancoDeDados;
	
	public LivrariaDAO(){
		try {
			bancoDeDados = new BancoDeDados( nomeBanco );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirLivro(Livro livro){
		bancoDeDados.inserirLivro(livro);
	}
	
	public List<Livro> listarLivros(){
		List<Livro> livros = bancoDeDados.listarLivros();		
		return livros;
	}

	
}

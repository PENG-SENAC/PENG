package com.senac.livraria.dao.bancodados;

import java.awt.Window.Type;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.FilerException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.senac.livraria.model.Livro;


/**
 * Banco de Dados dos Livros
 * As informações sobre os livros deverão ser armazenados em arquivos.
 * 
 * Faz a Conversão do JSON para o tipo correto e envia para a classe DAO
 * 
 * @author Guilherme Rocha Araujo aka Gartisk
 */
public class BancoDeDados extends OperacaoComArquivo implements BancoParaArquivoInterface{
	
	public BancoDeDados(String nomeDoBanco) throws FilerException, IOException{
		super( nomeDoBanco );
	}
	
	
	public List<Livro> listarLivros(){
		JSONArray jsonLivros = (JSONArray) JSONValue.parse( this.dadosBanco.toString() );
		List<Livro> livros = new ArrayList<Livro>();
		
		if( jsonLivros != null ){
			for (Object objectLivro : jsonLivros) {
				JSONObject  jsonLivro = (JSONObject) objectLivro;
				Livro livro = new Livro();
				livro.setId( (String)jsonLivro.get("id") );
				livro.setTitulo( (String)jsonLivro.get("titulo") );
				livro.setAutor( (String)jsonLivro.get("autor") );
				livro.setEditor( (String)jsonLivro.get("editor") );
				livro.setDataLancamento( (String)jsonLivro.get("dataLancamento") );
				livros.add( livro );
			}
		}
		return livros;
	}
	
	@SuppressWarnings("unchecked")
	public void inserirLivro(Livro livro){
		
		JSONParser parser = new JSONParser();
		JSONArray jsonLivros = null;
		
		Gson gson = null;
		String prettyJSON = null;
		
		JSONObject jsonLivro = new JSONObject();
		jsonLivro.put("id", livro.getId());
		jsonLivro.put("titulo", livro.getTitulo());
		jsonLivro.put("autor", livro.getAutor());
		jsonLivro.put("editor", livro.getEditor());
		jsonLivro.put("dataLancamento", livro.getDataLancamento());
				
		try {
			jsonLivros = (JSONArray) parser.parse( this.dadosBanco.toString() );
									
		} catch (ParseException e) {
			//Caso aconteça algum erro durante o parser, banco é resetado
			if( jsonLivros == null || jsonLivros.size() == 0){
				jsonLivros = new JSONArray();
			}
			
		}
		
		jsonLivros.add( jsonLivro );
		//Ajusta JSON para que ele fique com a formatação bonita ;)
		gson = new GsonBuilder().setPrettyPrinting().create();
        prettyJSON = gson.toJson(jsonLivros);
		this.dadosBanco = new StringBuffer( prettyJSON );
		
		this.armazenarNoArquivo();
		try {
			this.carregarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 
	 * @param id Se o valor retornado for negativo o valor nao existe no banco.
	 * @return
	 */
	public int checkLivroID(String id){
		JSONParser parser = new JSONParser();
		JSONArray jsonLivros = null;
		int position = -1;
		
							
		try {
			jsonLivros = (JSONArray) parser.parse( this.dadosBanco.toString() );
			
			
			int i = 0; 
			for (Object object : jsonLivros) {
				JSONObject jsonLivro = (JSONObject) object;
				
				if( id.equals( jsonLivro.get("id") ) ){
					
				}
				i++;
			}
			position = i;
			
		} catch (ParseException e) {
			return -1;			
		}
			
		
		
		return position;
	}
	
	public void removerLivro(String id) {
		JSONParser parser = new JSONParser();
		JSONArray jsonLivros = null;
		
		Gson gson = null;
		String prettyJSON = null;
								
		try {
			jsonLivros = (JSONArray) parser.parse( this.dadosBanco.toString() );
									
		} catch (ParseException e) {
			//Caso aconteça algum erro durante o parser, banco é resetado
			if( jsonLivros == null || jsonLivros.size() == 0){
				jsonLivros = new JSONArray();
			}
			
		}
		/**
		 * @DOING
		 */
		for (Object object : jsonLivros) {
			JSONObject jsonLivro = (JSONObject) object;
			//jsonLivro.
			System.out.println( "jsonLivro: "+ jsonLivro.toJSONString() );
			
		}
		
	}
	
	
	
	
}

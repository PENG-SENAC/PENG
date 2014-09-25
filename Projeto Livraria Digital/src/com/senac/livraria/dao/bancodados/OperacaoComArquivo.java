package com.senac.livraria.dao.bancodados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import javax.annotation.processing.FilerException;


/**
 * Livraria PENG
 * 
 * Esta classe é responsável por:
 * 	-criar arquivo.
 *  -carregar no conteudo no buffer. 
 *  -inserir conteudo no arquivo.
 *
 * @author Guilherme Rocha Araujo aka Gartisk
 */
public abstract class OperacaoComArquivo {
	private final String pathDiretorio = "C:/Livraria_Digital";
	private final String extensaoArquivo = "txt";
	private String fullPath;
	private String nomeDoBanco;
	protected StringBuffer dadosBanco = null;
	
	public OperacaoComArquivo(String nomeDoBanco) throws FilerException, IOException{
		
		if( null == nomeDoBanco || "" == nomeDoBanco ){
			throw new FilerException("OperacaoComArquivo Construtor - Arquivo deve ter um nome diferente de vazio ou nulo.");
		}
		
		this.nomeDoBanco = nomeDoBanco;
		this.fullPath = this.pathDiretorio + "/" + this.nomeDoBanco + "." + this.extensaoArquivo;
		
		criarPasta();
		criarArquivo();
		carregarArquivo();
	}
	
	private void criarArquivo(){
		File file = new File(this.fullPath);
		
		if( !file.exists() && !file.isFile() ){
			try {
				file.createNewFile();
				System.out.println("OperacaoComArquivo.criarArquivo - Arquivo Criado: "+nomeDoBanco+"."+extensaoArquivo);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			System.out.println("OperacaoComArquivo.criarArquivo - Arquivo já Existente: "+nomeDoBanco+"."+extensaoArquivo);
		}
	
	}
	
	private void criarPasta(){
		File folder = new File(pathDiretorio);
		
		if( !folder.exists() && !folder.isDirectory()  ){
			folder.mkdirs();
			System.out.println("OperacaoComArquivo.criarPasta - Diretorio Criado: "+pathDiretorio);
		}else{
			System.out.println("OperacaoComArquivo.criarPasta - Diretorio já Existente: "+pathDiretorio);
		}
		
	}
	
	protected void carregarArquivo() throws IOException{
		this.dadosBanco = new StringBuffer();
			
		InputStream ips = new FileInputStream( this.fullPath );
    	InputStreamReader ipsr = new InputStreamReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        
        String line;
        while( (line=br.readLine()) != null ){
			this.dadosBanco.append( line +"\n" );
		}
		br.close();
		System.out.println("OperacaoComArquivo.carregarArquivo - Arquivo Carregado: "+fullPath);
	}
	
	protected void armazenarNoArquivo(){
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		if(this.dadosBanco.length() > 0) {
					
			try {
				fw = new FileWriter(fullPath);
				bw = new BufferedWriter( fw );
				
				bw.write( this.dadosBanco.toString() );
				
				System.out.println("OperacaoComArquivo.inserirNoarquivo - Inserido no Arquivo");
				bw.close();
				fw.close();
			} catch (IOException e) {
				System.out.println("OperacaoComArquivo.inserirNoarquivo - Falha ao Inserir em Arquivo ");
				e.printStackTrace();
			}
		} else {
			System.out.println("OperacaoComArquivo.inserirNoarquivo - Nada a Adicionar");
		}
		
	}
	
	public String getBancoFullPath(){
		return fullPath;
	}
}

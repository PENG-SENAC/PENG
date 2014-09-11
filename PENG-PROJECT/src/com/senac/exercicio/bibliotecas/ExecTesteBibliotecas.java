package com.senac.exercicio.bibliotecas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.senac.banco.modelo.conta.ContaTransf;
import com.senac.exercicio.collections_generics.ExecTesteCollectionsEGenerics;

/**
 * Senac - Santa Luzia
 * PENG-JAVA : Pos Graduação em Engenharia de Software com Java
 * 
 * Exercicios em Aula de Java
 * Apostila Java Bas OO 10 - Bibliotecas Java
 * professor Clayton Escouper
 * @author Guilherme Rocha Araujo aka Gartisk
 * url: http://github.com/gartisk 
 */
public class ExecTesteBibliotecas {
	
	public static void main(String[] args) throws IOException{
		/* Selecione o metodo a ser utilizado */
		
		//ExecTesteBibliotecas.criaTxt();
		//ExecTesteBibliotecas.leTxt();
		//ExecTesteBibliotecas.leCharTeclado();
		//ExecTesteBibliotecas.stringTeste();
		//ExecTesteBibliotecas.mathTeste();
		ExecTesteBibliotecas.metObjToStr();
		
		
	} 
	
	
	public static void criaTxt() throws IOException{
		OutputStream os = new FileOutputStream("teste.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write("testando\na\nleitura");
		bw.close();
		System.out.println("Escrita realizada com sucesso");
	}
	
	public static void leTxt() throws IOException{
		InputStream is = new FileInputStream("teste.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String s = "";
		while(s != null){
			System.out.println(s);
			s = br.readLine();
		}
	}
	
	public static void leCharTeclado(){
		System.out.println("Digite uma tecla: ");
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		
		char c;
		try {
			c = (char) isr.read();
			System.out.println("Você digitou a letra "+c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void metObjToStr(){
		ClienteBibliotecas1 c1 = new ClienteBibliotecas1();
		
		System.out.println(c1);
		System.out.println(c1.toString());
		
		ClienteBibliotecas2 c2 = new ClienteBibliotecas2("patati");
		
		System.out.println(c2);
		System.out.println(c2.toString());
	}
	
	public static void stringTeste(){
		String a = new String("Java Senac");
		String b = "Java Senac";
		
		if( a == b){
			System.out.println("a e b são objetos iguais");
		} else {
			System.out.println("a e b são objetos diferentes");
		}
		
		if( a.equals(b)){
			System.out.println("a e b tem conteudo iguais");
		} else {
			System.out.println("a e b tem conteudo diferentes");
		}
		
		String[] split = a.split("a");
		System.out.println("String split: "+ split[0] +" - "+  split[1]  );;
		
		System.out.println("String compareTo: "+a.compareTo("Java Senac"));
		
		System.out.println("String compareToIgnoreCase: "+a.compareToIgnoreCase("Java Senac") );
		
		System.out.println("String charAt: "+a.charAt(2) );
		
		System.out.println("String length: "+a.length() );
		
		System.out.println("String substring: "+a.substring(3) );
		
		System.out.println("String trim: "+( a+" trim  ").trim() );
		
		System.out.println("String indexOf: "+a.indexOf("v") );
		
		System.out.println("String lastIndexOf: "+a.lastIndexOf("a") );
		
		System.out.println("String isEmpty: "+a.isEmpty() );
		
		System.out.println("String contains: "+a.contains("Senac") );
		
		System.out.println("String matches: "+a.matches("Senac") );
		
		System.out.println("String replace: "+a.replace("a", "e") );
		
		System.out.println("String replaceAll: "+a.replaceAll("a", "e") );
	}
	
	public static void mathTeste(){
		System.out.println( "Math ABS: " + Math.abs(-20) );
		
		System.out.println( "Math round: " + Math.round(2.456) );
		
		System.out.println( "Math random: " + Math.random() );
		
		System.out.println( "Math sqrt: " + Math.sqrt(3.56733) );
		
		System.out.println( "Math floor: " + Math.floor(3.56733) );
		
		System.out.println( "Math max: " + Math.max(3.144560, 3.1243546) );
		
		System.out.println( "Math min: " + Math.min(3.144560, 3.1243546) );
		
		System.out.println( "Math ceil: " + Math.ceil(3.144560) );
		
		System.out.println( "Math log: " + Math.log(3.144560) );
		
		System.out.println( "Math pow: " + Math.pow(4, 2) );
		
		System.out.println( "Math toDegree: " + Math.toDegrees(23.76765	) );
		
		System.out.println( "Math toRadians: " + Math.toRadians( 25.456) );
		
		System.out.println( "Math exp: " + Math.exp( 25.456) );
	}
}

package com.senac.exercicio.tratando_exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Senac - Santa Luzia
 * PENG-JAVA : Pos Graduação em Engenharia de Software com Java
 * 
 * Exercicios em Aula de Java
 * Apostila Java Bas OO 9 - Tratando Excecoes
 * professor Clayton Escouper
 * @author Guilherme Rocha Araujo aka Gartisk
 * @authorUrl http://github.com/gartisk 
 */
public class execTesteExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args){
		//execTesteExceptions.metodo0();
		//execTesteExceptions.testeException3();
		//execTesteExceptions.testeException5();
	}
	
	//INICIO TesteException2
	public static void metodo0(){
		System.out.println("Inicio do Metodo 0");
		metodo1();
		System.out.println("Fim do Metodo 0");
	}
	
	public static void metodo1(){
		System.out.println("Inicio do Metodo 1");
		metodo2();
		System.out.println("Fim do Metodo 1");
	}
	
	public static void metodo2(){
		System.out.println("Inicio do Metodo 2");
		
		int array[];
		array = new int[10];
		
		try{
			for( int i=0; i<20; i++ ){
				array[i] = i;
				System.out.println(i);
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Erro pego (catched): "+e);

		}
		System.out.println("Fim do Metodo 2");
		
	}
	
	//FIM TesteException3
	public static void testeException3(){
		try {
			new java.io.FileReader("arquivoTeste.txt");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testeException5() throws IllegalAccessException, SQLException, IOException{
		System.out.println("Vários catches");
		// Nesse caso o método preferiu passar o tratamento das checked exceptions para quem chamá-las.
	}
	
}

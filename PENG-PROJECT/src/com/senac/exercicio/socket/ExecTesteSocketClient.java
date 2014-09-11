package com.senac.exercicio.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


/**
 * Senac - Santa Luzia
 * PENG-JAVA : Pos Graduação em Engenharia de Software com Java
 * 
 * Exercicios em Aula de Java
 * 
 * professor Clayton Escouper
 * @author Guilherme Rocha Araujo aka Gartisk
 * @authorUrl http://github.com/gartisk 
 */
public class ExecTesteSocketClient {
	
	public static void main(String[] args) throws IOException{
		Socket client = new Socket("127.0.0.1", 10000);
		System.out.println("Cliente conectado ao servidor");
		
		Scanner s = new Scanner( System.in );
		PrintStream out = new PrintStream(client.getOutputStream());
		
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		
		out.close();
		s.close();
		client.close();
	}

}

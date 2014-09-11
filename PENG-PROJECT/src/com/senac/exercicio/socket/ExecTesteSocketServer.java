package com.senac.exercicio.socket;

import java.io.IOException;
import java.net.ServerSocket;
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
public class ExecTesteSocketServer {
		
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(10000);
		System.out.println("Porta 10000 aberta, aguardando conexão da cliente");
		
		Socket client = server.accept();
		System.out.println("Conexao do cliente"+client.getInetAddress().getAddress());
		
		Scanner s = new Scanner( client.getInputStream() );
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		
		s.close();
		server.close();
		client.close();
	}

}

package com.senac.exercicio.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ExecTesteSocketClient {
	
	
	
	public static void main(String[] args) throws IOException{
		Socket client = new Socket("10.7.7.151", 10001);
		System.out.println("CLIENTE: Conectado no Servidor");
		
		System.out.println("ESCREVA UMA MENSAGEM: ");
		Scanner s = new Scanner( System.in );
		PrintStream out = new PrintStream(client.getOutputStream());
		
		while (s.hasNextLine()) {
			out.println("CLIENTE DIZ AO SERVIDOR: "+s.nextLine());
		}
		
		out.close();
		s.close();
		client.close();
	}

}

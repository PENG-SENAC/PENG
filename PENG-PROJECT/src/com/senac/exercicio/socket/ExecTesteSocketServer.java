package com.senac.exercicio.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ExecTesteSocketServer {
	
	
	
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(10001);
		System.out.println("SERVIDOR: Porta 10000 aberta, aguardando conexão da cliente. ");
		
		Socket client = server.accept();
		System.out.println("Cliente: "+client.getInetAddress().getHostAddress()+" CONECTADO. " );
		
		Scanner s = new Scanner( client.getInputStream() );
		while (s.hasNextLine()) {
			System.out.println(s.nextLine());
		}
		
		s.close();
		server.close();
		client.close();
	}

}

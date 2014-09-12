package com.senac.exercicio.threads;

public class ExecTesteContador {

	public static void main(String[] args) {
		Contador contador1 = new Contador();
		contador1.setCont(1);
		Thread thread1 = new Thread(contador1);
		thread1.start();
		
		
		Contador contador2 = new Contador();
		contador2.setCont(2);
		Thread thread2 = new Thread(contador2);
		thread2.start();

	}

}

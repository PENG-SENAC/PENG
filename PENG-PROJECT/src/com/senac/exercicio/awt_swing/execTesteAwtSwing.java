package com.senac.exercicio.awt_swing;

import java.awt.Frame;

public class execTesteAwtSwing {
	
	public static void main(String[] args) {
		//execTesteAwtSwing.testeExemplo01();
		//execTesteAwtSwing.testeExemplo02();
		//execTesteAwtSwing.testeExemplo03();
		execTesteAwtSwing.testeExemplo08();
	}
	
	public static void testeExemplo01(){
		new Exemplo01();
	}
	
	public static void testeExemplo02(){
		Frame f = new Frame("Testando a classe Graphics");
		Exemplo02 ex02 = new Exemplo02();
		f.add(ex02);
		f.setSize(400, 200);
		f.setVisible(true);
	}
	
	public static void testeExemplo03(){
		new Exemplo03();
	}
	
	public static void testeExemplo08() {
		new Exemplo08();
	}
}

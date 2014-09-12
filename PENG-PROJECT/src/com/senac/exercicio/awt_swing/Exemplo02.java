package com.senac.exercicio.awt_swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class Exemplo02 extends Panel{
	
	public Exemplo02() {
		//setBackground(Color.BLUE);
	}
	
	@Override
	public void paint(Graphics g ){
		//setColor: define cor no padrão RGB
		g.setColor( new Color(200, 0, 200) );
		
		//setFont: define as configurações da fonte
		g.setFont( new Font("Arial", Font.BOLD, 16));
		g.drawString("Primeiro exemplo com Graphics", 30, 100);
		g.setColor( new Color(0, 1.0f, 0));
		g.fillRect(30, 100, 150, 20);
	}
	
}

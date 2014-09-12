package com.senac.exercicio.awt_swing;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.TextField;

public class Exemplo03 extends Frame {
	
	public Exemplo03() {
		//Exemplo03 ex03 = new Exemplo03();
		super.setLayout( new FlowLayout() );
		super.setSize(600, 100);
		super.add( new Button("Clique aqui") );
		super.add( new Label("Texto de etiqueta") );
		super.add( new TextField(10) );
		
		CheckboxGroup cbg = new CheckboxGroup();
		super.add( new Checkbox("Homem", cbg, false) );
		super.add( new Checkbox("Mulher", cbg, false) );
		List list = new List(3, false);
		list.add("Java");
		list.add("C");
		list.add("C++");
		super.add(list);
		
		Choice chooser = new Choice();
		chooser.add("João");
		chooser.add("Maria");
		chooser.add("José");
		super.add(chooser);
		super.add( new Scrollbar() );
		super.setVisible(true);
	}

}

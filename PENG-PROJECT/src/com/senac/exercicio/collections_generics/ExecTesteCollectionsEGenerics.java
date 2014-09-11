package com.senac.exercicio.collections_generics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.senac.banco.modelo.conta.ContaTransf;

/**
 * Senac - Santa Luzia
 * PENG-JAVA : Pos Graduação em Engenharia de Software com Java
 * 
 * Exercicios em Aula de Java
 * Apostila Java Bas OO 11 - Collections e Generics
 * professor Clayton Escouper
 * @author Guilherme Rocha Araujo aka Gartisk
 * @authorUrl http://github.com/gartisk 
 */
public class ExecTesteCollectionsEGenerics {
	
	public static void main(String[] args) throws IOException{
		/* Selecione o metodo a ser utilizado */
		//ExecTesteCollectionsEGenerics.testaList();
		//ExecTesteCollectionsEGenerics.testaSet();
		//ExecTesteCollectionsEGenerics.testaMap();
	} 
	
	public static void testaMap(){
		ContaTransf contaTransf1 = new ContaTransf("", "");
		contaTransf1.depositar(10);
		ContaTransf contaTransf2 = new ContaTransf("", "");
		contaTransf2.depositar(20);
		ContaTransf contaTransf3 = new ContaTransf("", "");
		contaTransf3.depositar(30);
		
		Map<String, ContaTransf> mapaContas = new HashMap<String, ContaTransf>();
		mapaContas.put("caixa", contaTransf1);
		mapaContas.put("atendente", contaTransf2);
		mapaContas.put("gerente", contaTransf3);
		
		ContaTransf contaGerenteRecuperada = (ContaTransf) mapaContas.get("gerente");
		System.out.println(contaGerenteRecuperada.getSaldo() );
		
		for (Entry<String, ContaTransf> entry : mapaContas.entrySet()) {
			System.out.println( "Chave "+ entry.getKey() + " ContaTransf " + entry.getValue().getSaldo() );
		}
		
 	}
	
	public static void testaSet(){
		Set<String> objetos = new HashSet<String>();
		objetos.add("objeto1");
		objetos.add("objeto2");
		objetos.add("objeto3");
		objetos.add("objeto3");
		objetos.add("objeto2");
		objetos.add("objeto1");
		
		System.out.println(objetos.size());
		
		System.out.println(objetos+"\n");
		
		for (Object object : objetos) {
			System.out.println( object );
		}
		
	}
	
	public static void testaList(){
		List lista1 =  new ArrayList();
		lista1.add("Java");
		lista1.add("Senac");
		
		ContaTransf contaTransf1 = new ContaTransf("", "");
		contaTransf1.depositar(100);
		
		ContaTransf contaTransf2 = new ContaTransf("", "");
		contaTransf2.depositar(200);
		
		ContaTransf contaTransf3 = new ContaTransf("", "");
		contaTransf3.depositar(300);
		
		List<ContaTransf> contas = new ArrayList<ContaTransf>();
		contas.add(contaTransf1);
		contas.add(contaTransf2);
		contas.add(contaTransf3);
		
		System.out.println(contas.size());
		
		for (Object object : contas) {
			System.out.println(  ((ContaTransf)object).getSaldo() );
		}
	}

}

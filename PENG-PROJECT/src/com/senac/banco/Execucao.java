package com.senac.banco;
import com.senac.banco.controller.AcessoInterno;
import com.senac.banco.controller.ControleBonus;
import com.senac.banco.controller.ControleSalarios;
import com.senac.banco.modelo.funcionario.Funcionario;
import com.senac.banco.modelo.funcionario.Gerente;

/**
 * Pos Graduação em Engenharia de Software com Java
 * Senac - Santa Luzia
 * 
 * Exercicios em Aula de Java
 * 
 * professor: Clayton Escouper
 * @author Guilherme Rocha Araujo aka Gartisk
 * 	url: http://github.com/gartisk
 */
public class Execucao {
	
	
	public static void main(String[] args) {
		Execucao.exceptionTeste5();
	}
	
	/**
	 * Classe Abstrata e Interface
	 * @since 21/08/2014
	 * @author Guilherme R Araujo
	 */
	public static void interfaceTeste4(){
		int senha = 123;
		AcessoInterno f1 = new Gerente();
		f1.verificaSenha(senha);
	}
	
	/**
	 * Classe Exceções
	 * Apostila: Java Bas OO 9 - Tratando Excecoes
	 * 
	 * @since 21/08/2014
	 * @author Guilherme R Araujo
	 */
	public static void exceptionTeste5(){
		System.out.println("Inicio do metodo main");
		exceptionMetodo1();
		System.out.println("Fim do metodo main");
	}
	
	public static void exceptionMetodo1(){
		System.out.println("Inicio do metodo 1");
		exceptionMetodo2();
		System.out.println("Fim do metodo 1");
	}
	
	public static void exceptionMetodo2(){
		System.out.println("Inicio do metodo 2");
		int array[];
		array = new int[10];
		
		try{
			for (int i = 0; i < 20 ; i++) {
				array[i] = i;
				System.out.println(i);
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("Erro capturado "+e);
			
		}
		
		System.out.println("Fim do metodo 2");
	}
	
	/**** ^^^FIM EXCEPTIONS^^^ ****/
	
	public static void teste3(){
		ControleSalarios controleSalarios = new ControleSalarios();
		ControleBonus controleBonus = new ControleBonus();
		Funcionario funcionario = new Funcionario();
		
		funcionario.setSalario(1000);
		controleSalarios.setTotalSalarios(funcionario);
		controleBonus.setTotalBonus(funcionario);
		System.out.println("Salario funcionario "+funcionario.getSalario());
		System.out.println("Bonus de funcionario "+funcionario.getBonus());
		
		Funcionario gerente = new Gerente();
		controleSalarios = new ControleSalarios();
		controleBonus = new ControleBonus();
		
		gerente.setSalario(10000);
		controleSalarios.setTotalSalarios(gerente);
		controleBonus.setTotalBonus(gerente);
		System.out.println("Salario Gerente "+controleSalarios.getTotalSalarios());
		System.out.println("Bonus de Gerente "+controleBonus.getTotalBonus());
		
	}
	
	public void teste2(){
		Funcionario funcionario = new Funcionario();
		funcionario.setSalario(1000);
		double salarioFuncionario = funcionario.getSalario();
		
		System.out.println("Salario funcionario "+salarioFuncionario);
		System.out.println("Bonus de funcionario "+funcionario.getBonus());
		
		Gerente gerente = new Gerente();
		gerente.setSalario(10000);
		System.out.println("Salario gerente "+gerente.getSalario());
		System.out.println("Bonus de gerente "+gerente.getBonus());
		
		Funcionario funcionario2 = gerente;
		funcionario2.setSalario(18000);
		System.out.println("Salario gerente "+funcionario2.getSalario());
		System.out.println("Bonus de gerente "+funcionario2.getBonus());
		
	}
	
	public void teste1(){
		Funcionario funcionario = new Funcionario();
		funcionario.setSalario(1000);
		
		System.out.println("Salario do Funcionario 1: "+funcionario.getSalario());
		System.out.println("Bonus do Funcionario 1: "+funcionario.getBonus());
		
		Gerente gerente = new Gerente();
		gerente.setSalario(20000);
		
		System.out.println("Salario do Funcionario 1: "+gerente.getSalario());
		System.out.println("Bonus do Funcionario 1: "+gerente.getBonus());
	}

}
 
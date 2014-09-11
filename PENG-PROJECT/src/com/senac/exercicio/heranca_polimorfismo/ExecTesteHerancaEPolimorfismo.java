package com.senac.exercicio.heranca_polimorfismo;

import com.senac.banco.controller.ControleBonus;
import com.senac.banco.modelo.conta.ControleSalarial;
import com.senac.banco.modelo.funcionario.Funcionario;
import com.senac.banco.modelo.funcionario.Gerente;


/**
 * Senac - Santa Luzia
 * PENG-JAVA : Pos Graduação em Engenharia de Software com Java
 * 
 * Exercicios em Aula de Java
 * Apostila Java Bas OO 6 - OO II - Heranca e Polimorfismo
 * professor Clayton Escouper
 * @author Guilherme Rocha Araujo aka Gartisk
 * @authorUrl http://github.com/gartisk 
 */
public class ExecTesteHerancaEPolimorfismo {

	public static void main(String[] args) {
        //ExecTesteHerancaEPolimorfismo.testeHeranca();
		//ExecTesteHerancaEPolimorfismo.testePolimorfismo();
	}
	
	public static void testeHeranca(){
		Funcionario funcionario = new Funcionario();
        funcionario.setSalario(1000);
        double salFuncionario = funcionario.getSalario();
        System.out.println("salario do funcionario f1="+ salFuncionario);
        System.out.println("Bonus do funcionario f1="+ funcionario.getBonus());
        
        Gerente gerente = new Gerente();
        gerente.setSalario(10000);
        System.out.println("salario do gerente g1="+gerente.getSalario());
        System.out.println("Bonus do gerente g1="+gerente.getBonus());
	}
	
	public static void testePolimorfismo(){
		ControleSalarial controleSalarial = new ControleSalarial();
		ControleBonus controleBonus = new ControleBonus();
		
		Gerente gerente1 = new Gerente();	
		gerente1.setSalario(10000);
		System.out.println("Gerente 01 - Total Salario: "+ controleSalarial.getTotalSalarios());
		
		Gerente gerente2 = new Gerente();
		gerente2.setSalario(15000);
		controleSalarial.setTotalSalarios(gerente2);
		System.out.println("Gerente 02 - Total Salario: " + controleSalarial.getTotalSalarios());
		
		Funcionario funcionario = new Funcionario();
		controleBonus.setTotalBonus(funcionario);
		System.out.println("Funcionario - Bonus: " + controleBonus.getTotalBonus());
		
		controleBonus.setTotalBonus(gerente2);
		System.out.println("Gerente 02 - Bonus: " + controleBonus.getTotalBonus());
	}

}

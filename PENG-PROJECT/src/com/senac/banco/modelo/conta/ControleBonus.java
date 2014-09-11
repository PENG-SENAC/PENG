package com.senac.banco.modelo.conta;

import com.senac.banco.modelo.funcionario.Funcionario;


public class ControleBonus {

	private double totalBonus = 0;
	
	public void setTotalBonus(Funcionario funcionario){
		this.totalBonus += funcionario.getBonus();
	}
	
	public double getTotalBonus(){
		return this.totalBonus;
	}
}

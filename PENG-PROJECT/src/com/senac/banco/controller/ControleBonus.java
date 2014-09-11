package com.senac.banco.controller;

import com.senac.banco.modelo.funcionario.Funcionario;

public class ControleBonus {
	private double totalBonus;

	public double getTotalBonus() {
		return totalBonus;
	}

	public void setTotalBonus(Funcionario funcionario) {
		this.totalBonus += funcionario.getBonus();
	}
	
	
}

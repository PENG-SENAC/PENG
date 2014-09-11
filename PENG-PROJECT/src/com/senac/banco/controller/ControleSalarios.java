package com.senac.banco.controller;

import com.senac.banco.modelo.funcionario.Funcionario;

public class ControleSalarios {
	private double totalSalarios = 0;
	
	public double getTotalSalarios() {
		return totalSalarios;
	}

	public void setTotalSalarios(Funcionario funcionario) {
		this.totalSalarios = funcionario.getSalario();
	}
	
}

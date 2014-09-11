package com.senac.banco.modelo.conta;

import com.senac.banco.modelo.funcionario.Funcionario;

public class ControleSalarial {

	private double totalSalarios = 0;

	public double getTotalSalarios() {
		return totalSalarios;
	}

	public void setTotalSalarios(Funcionario funcionario) {
		this.totalSalarios = funcionario.getSalario();
	}
	
	
}

package com.senac.banco.modelo.funcionario;

import com.senac.banco.controller.AcessoInterno;
import com.senac.banco.modelo.funcionario.Funcionario;

public class Gerente extends Funcionario implements AcessoInterno{
	int senha;
	
	public double getBonus(){		
		return super.getBonus()+2000;
	}

	@Override
	public boolean verificaSenha(int senha) {
		if(this.senha == senha){
			System.out.println("Acesso Autorizado");
			return true;
		} 
		System.out.println("Acesso não autorizado");
		return false;
		
	}


}



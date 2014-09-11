package com.senac.banco.modelo.funcionario;

import com.senac.banco.controller.AcessoInterno;

public class Caixa extends Funcionario implements AcessoInterno{

	@Override
	public boolean verificaSenha(int senha) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
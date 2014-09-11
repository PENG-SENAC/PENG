package com.senac.banco.controller;

public class ControleInterno {
	private int senha;
	
	public void verificaSenha(AcessoInterno interessadoEmAcessar){
		interessadoEmAcessar.verificaSenha(senha);
	}

}

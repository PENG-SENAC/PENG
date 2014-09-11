package com.senac.banco.modelo.conta;

public abstract class Conta {
	private int numero;
	private String nome;
	protected double saldo;
	private double limite;
	
	boolean sacar(double valor){
		if((this.saldo + this.limite) < valor){
			return false;
			} else {
				this.saldo -= valor;
				return true;						
			}
	}
	
	
	void depositar(double valor){
		this.saldo+=valor;		
		
	}

	void correcao(double taxa){
		this.saldo += saldo  * taxa;
	}
	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public double getLimite() {
		return limite;
	}


	public void setLimite(double limite) {
		this.limite = limite;
	}


}

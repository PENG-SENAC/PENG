package com.senac.banco.modelo.conta;

import com.senac.banco.modelo.funcionario.Cliente;


public class ContaTransf extends Conta {
	private static int contadorContas;
	
	int numero;
	double saldo;
	double limite;
	Cliente cliente = new Cliente();
		
    public ContaTransf(String nome, String cpf){
    	this.cliente.setNome(nome);
    	this.cliente.setCpf(cpf);
    	System.out.println("ContaTransf: Classe sendo construida..");
    	ContaTransf.contadorContas++;
    }
    
	@Override
	public void depositar(double valor) {
		// TODO Auto-generated method stub
		super.depositar(valor);
	}
    
    public static int getContadorContas(){
    	return ContaTransf.contadorContas;
    }
}

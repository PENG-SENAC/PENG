package com.senac.exercicio.bibliotecas;

import java.io.Serializable;

public class ClienteBibliotecas2 implements Serializable{
	private static final long serialVersionUID = 7961747895521739144L;
	private String nome;
	private String endereco;
	
	public ClienteBibliotecas2(String nome){
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente2 [nome=" + nome + ", endereco=" + endereco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteBibliotecas2 other = (ClienteBibliotecas2) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
}

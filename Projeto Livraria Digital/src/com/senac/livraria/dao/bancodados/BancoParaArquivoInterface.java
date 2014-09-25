
package com.senac.livraria.dao.bancodados;

import java.util.List;

import com.senac.livraria.model.Livro;

public interface BancoParaArquivoInterface {

	public List<Livro> listarLivros();
	
	public void inserirLivro(Livro livro);
	
	public void removerLivro(String id);

}

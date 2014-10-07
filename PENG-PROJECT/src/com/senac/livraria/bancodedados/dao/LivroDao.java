package com.senac.livraria.bancodedados.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.senac.livraria.bancodedados.jdbc.FabricaDeConexoes;
import com.senac.livraria.bancodedados.model.Livro;

public class LivroDao {
	private Connection con;
	
	public LivroDao(){
		this.con = FabricaDeConexoes.getConnection();
		
	}
	
	public void adiciona(Livro livro){
		
		try{
			Connection con =  FabricaDeConexoes.getConnection();
			String sql = "INSERT INTO livros(titulo, autor, editora, email, dataLancamento) values (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, livro.getTitulo());
			stmt.setString(2, livro.getAutor());
			stmt.setString(3, livro.getEditora());
			stmt.setString(4, livro.getEmail());
			stmt.setDate(5, new Date( livro.getDataLancamento().getTimeInMillis()));
			stmt.execute();
			con.close();
		} catch( SQLException e){
			e.printStackTrace();
		}
		
	}
	
	public List<Livro> getLista(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Livro> livros = new ArrayList<Livro>();
		try {
			
			String sql = "SELECT * FROM livros";
			stmt = this.con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Livro livro = new Livro();
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setEditora(rs.getString("editora"));
				livro.setEmail(rs.getString("email"));
				
				Calendar data = Calendar.getInstance();
				data.setTime( rs.getDate("dataLancamento") );
				livro.setDataLancamento(data);
				
				livros.add(livro);
				
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return livros;
	}

}

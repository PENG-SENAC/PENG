package com.senac.livraria.bancodedados.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class JdbcInsere {
	
	public static void main(String[] args) {
		
		try{
			Connection con =  FabricaDeConexoes.getConnection();
			String sql = "INSERT INTO livros(titulo, autor, editora, email, dataLancamento) values (?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, "PENG");
			stmt.setString(2, "Clayton");
			stmt.setString(3, "clayton@peng.com");
			stmt.setString(4, "Senac Rio Editora");
			stmt.setString(5, null);
			stmt.execute();
			con.close();
		} catch( SQLException e){
			e.printStackTrace();
		}
		
	}

}

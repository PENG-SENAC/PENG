package com.senac.livraria.bancodedados.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	
	public static Connection getConnection(){
		Connection con = null;
		try{
			con =  DriverManager.getConnection("jdbc:mysql://localhost/testpeng", "root", "");
		}catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
}

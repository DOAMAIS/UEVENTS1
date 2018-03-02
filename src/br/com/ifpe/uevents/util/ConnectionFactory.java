package br.com.ifpe.uevents.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() throws SQLException{
		
		//Alterar aqui antes de executar
		String banco = "uvents";
		String user = "root";
		String senha = "";

		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			throw new SQLException(e);
		}
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ banco, user, senha);
	}
}

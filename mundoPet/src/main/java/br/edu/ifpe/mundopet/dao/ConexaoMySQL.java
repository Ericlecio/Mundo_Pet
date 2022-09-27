package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	public static Connection getConexaoMySQL() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mundo pet","root","");
		return connection;
	}
}

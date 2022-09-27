package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.edu.ifpe.mundopet.model.Login;

public class LoginDao {
	public void adicionaLogin(Login login) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `login`"
				+ "(`email`,`senha`) "
				+ " VALUES (? , ? )";
		PreparedStatement stmt =  connection.prepareStatement(sql);

		stmt.setString(1, login.getEmail());
		stmt.setString(2, login.getSenha());

		stmt.execute();
		stmt.close();
		connection.close();

	}
}

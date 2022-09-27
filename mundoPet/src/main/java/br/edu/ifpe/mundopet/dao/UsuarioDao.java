package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.mundopet.model.Usuario;

public class UsuarioDao {
	public void adicionarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `usuario`"
				+ "( `nome`,`data_nasc`,`email`,`cpf`, `senha`) "
				+ " VALUES (? , ? , ? , ?, ?, ?)";
		PreparedStatement stmt =  connection.prepareStatement(sql);

		stmt.setString(1, usuario.getNome());
		stmt.setInt(2, usuario.getData_Nasc());
		stmt.setString(3, usuario.getEmail());
		stmt.setLong(4, usuario.getCpf());
		stmt.setString(5, usuario.getSenha(1));

		stmt.execute();
		stmt.close();
		connection.close();
	}
	public List<Usuario> consultarTodosUsuarios() throws ClassNotFoundException, SQLException{
		Connection connection =  ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idusuario`, `nome`, `data_nasc`, `email`, `cpf`, `senha` FROM `usuario`";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();

		while(resultSet.next()) {

			Usuario usuario = new Usuario();

			int idusuario =  resultSet.getInt("idusuario");
			usuario.setIdusuario(idusuario);
			String nome = resultSet.getString(2);
			usuario.setNome(nome);
			usuario.setData_Nasc(resultSet.getInt(3));
			usuario.setEmail(resultSet.getString(4));
			usuario.setCpf(resultSet.getInt(5));
			usuario.setSenha(resultSet.getString(6));

			listaTodosUsuarios.add(usuario);
		}
		stmt.close();
		connection.close();

		return listaTodosUsuarios;

	}
}

package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.mundopet.model.Usuario;

@Repository

public class UsuarioDao {
	public void adicionarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `usuario`" + "(`nome`,`data_nasc`,`email`,`cpf`, `senha`) "
				+ " VALUES (? , ? , ? , ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, usuario.getNome());
		stmt.setDate(2, new Date(usuario.getData_Nasc().getTime()));
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getCpf());
		stmt.setString(5, usuario.getSenha());

		stmt.execute();
		stmt.close();
		connection.close();
	}

	public Usuario consultarUsuariosEmailSenha(Usuario pUsuario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idusuario`, `nome`, `data_nasc`, `email`, `cpf`, `senha` FROM `usuario` where 'email'= ? and 'senha'= ?";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, pUsuario.getEmail());
		stmt.setString(2, pUsuario.getSenha());

		ResultSet resultSet = stmt.executeQuery();

		Usuario usuario = new Usuario();
		if (resultSet.next()) {

			usuario.setIdusuario(resultSet.getInt(1));
			String nome = resultSet.getString(2);
			usuario.setNome(nome);
			usuario.setData_Nasc(new java.util.Date(resultSet.getDate(3).getTime()));
			usuario.setEmail(resultSet.getString(4));
			usuario.setCpf(resultSet.getString(5));
			usuario.setSenha(resultSet.getString(6));

		}
		stmt.close();
		connection.close();

		return usuario;

	}

	public List<Usuario> consultarTodosUsuarios() throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idusuario`, `nome`, `data_nasc`, `email`, `cpf`, `senha` FROM `usuario`";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Usuario> listaTodosUsuarios = new ArrayList<Usuario>();

		while (resultSet.next()) {

			Usuario usuario = new Usuario();

			usuario.setIdusuario(resultSet.getInt(1));
			String nome = resultSet.getString(2);
			usuario.setNome(nome);
			usuario.setData_Nasc(new java.util.Date(resultSet.getDate(3).getTime()));
			usuario.setEmail(resultSet.getString(4));
			usuario.setCpf(resultSet.getString(5));
			usuario.setSenha(resultSet.getString(6));

			listaTodosUsuarios.add(usuario);
		}
		stmt.close();
		connection.close();

		return listaTodosUsuarios;

	}

	public void AtualizarUsuairo(Usuario usuario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "UPDATE `usuario` set `nome` = ?, `data_Nasc`= ?, `email` = ?, `Cpf` = ?, `senha` = ? where `idusuario`= ? ";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, usuario.getNome());
		stmt.setDate(2, new Date(usuario.getData_Nasc().getTime()));
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getCpf());
		stmt.setString(5, usuario.getSenha());
		stmt.setInt(6, usuario.getIdusuario());

		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

	public void DeletarUsuario(int idusuario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "DELETE FROM `usuario` WHERE `idusuario`=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(2, idusuario);

		stmt.executeUpdate();
		stmt.close();
		connection.close();

	}
}

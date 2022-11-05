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
import br.edu.ifpe.mundopet.model.Veterinario;

@Repository
public class VeterinarioDao {
	public void AdicionarVeterinario(Veterinario veterinario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `veterinario`" + "(`nome`, `data_nasc`, `email`,`cpf`,`crmv`, `senha`)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, veterinario.getNome());
		stmt.setDate(2, new Date(veterinario.getData_Nasc().getTime()));
		stmt.setString(3, veterinario.getEmail());
		stmt.setString(4, veterinario.getCpf());
		stmt.setString(5, veterinario.getCrmv());
		stmt.setString(6, veterinario.getSenha());

		stmt.execute();
		stmt.close();
		connection.close();
	}

	public Veterinario consultarVeterinariosEmailSenhaCrmv(Veterinario pVeterinario)
			throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idveterinario`, `nome`, `data_nasc`, `email`, `cpf`,`crmv`, `senha` FROM `veterinario` where 'email'= ? and 'senha'= ?";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, pVeterinario.getEmail());
		stmt.setString(2, pVeterinario.getSenha());
		stmt.setString(3, pVeterinario.getCrmv());


		ResultSet resultSet = stmt.executeQuery();

		Veterinario veterinario = new Veterinario();
		if (resultSet.next()) {

			veterinario.setIdveterinario(resultSet.getInt(1));
			String nome = resultSet.getString(2);
			veterinario.setNome(nome);
			veterinario.setData_Nasc(new java.util.Date(resultSet.getDate(3).getTime()));
			veterinario.setEmail(resultSet.getString(4));
			veterinario.setCpf(resultSet.getString(5));
			veterinario.setCrmv(resultSet.getString(6));
			veterinario.setSenha(resultSet.getString(7));

		}
		stmt.close();
		connection.close();

		return veterinario;

	}

	public List<Veterinario> ConsultarTodosVeterinarios() throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idveterinario`, `nome`, `data_nasc`, `email`, `cpf`,`crmv`, `senha` FROM `veterinario`";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Veterinario> listaTodosVeterinarios = new ArrayList<Veterinario>();

		while (resultSet.next()) {

			Veterinario veterinario = new Veterinario();

			int idveterinario = resultSet.getInt("idveterinario");
			veterinario.setIdveterinario(idveterinario);
			veterinario.setNome(resultSet.getString(2));
			veterinario.setData_Nasc(new java.util.Date(resultSet.getDate(3).getTime()));
			veterinario.setEmail(resultSet.getString(4));
			veterinario.setCpf(resultSet.getString(5));
			veterinario.setCrmv(resultSet.getString(6));
			veterinario.setSenha(resultSet.getString(7));

			listaTodosVeterinarios.add(veterinario);
		}
		stmt.close();
		connection.close();

		return listaTodosVeterinarios;
	}

	public void AtualizarVeterinario(Veterinario veterinario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "UPDATE `veterinario` set `nome` = ?, `data_nasc`= ?, `email` = ?, `cpf` = ?, `crmv` = ?, `senha` = ? where `idveterinario`= ? ";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, veterinario.getNome());
		stmt.setDate(2, new Date(veterinario.getData_Nasc().getTime()));
		stmt.setString(3, veterinario.getEmail());
		stmt.setString(4, veterinario.getCpf());
		stmt.setString(5, veterinario.getCrmv());
		stmt.setString(6, veterinario.getSenha());
		stmt.setInt(7, veterinario.getIdveterinario());

		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

	public void DeletarVeterinario(int idveterinario) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "DELETE FROM `veterinario` WHERE `idveterinario`=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(4, idveterinario);

		stmt.executeUpdate();
		stmt.close();
		connection.close();

	}
}

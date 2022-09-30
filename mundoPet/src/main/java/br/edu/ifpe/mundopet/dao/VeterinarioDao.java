package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.mundopet.model.Veterinario;



public class VeterinarioDao {
	public void AdicionarVeterinario(Veterinario veterinario) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `veterinario`"
				+ "(`nome`, `data_nasc`, `email`,`cpf`, `senha`)"
				+ "VALUES(?, ?, ?, ?, ?)";
		PreparedStatement stmt =  connection.prepareStatement(sql);

		stmt.setString(1, veterinario.getNome());
		stmt.setInt(2, veterinario.getData_Nasc());
		stmt.setString(3, veterinario.getEmail());
		stmt.setInt(4, veterinario.getCpf());
		stmt.setString(5, veterinario.getSenha());

		stmt.execute();
		stmt.close();
		connection.close();
	}
	public List<Veterinario> ConsultarTodosVeterinarios() throws ClassNotFoundException, SQLException{
		Connection connection =  ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idveterinario`, `nome`, `data_nasc`, `email`, `cpf`, `senha` FROM `veterinario`";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Veterinario> listaTodosVeterinarios = new ArrayList<Veterinario>();

		while(resultSet.next()) {

			Veterinario veterinario = new Veterinario();

			int idveterinario = resultSet.getInt("idveterinario");
			veterinario.setIdveterinario(idveterinario);
			veterinario.setNome(resultSet.getString(2));
			veterinario.setData_Nasc(resultSet.getInt(3));
			veterinario.setEmail(resultSet.getString(4));
			veterinario.setCpf(resultSet.getInt(5));
			veterinario.setSenha(resultSet.getString(6));

			listaTodosVeterinarios.add(veterinario);
		}
		stmt.close();
		connection.close();

		return listaTodosVeterinarios;
	}

	public void AtualizarVeterinario (Veterinario veterinario) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "UPDATE `veterinario` set `nome` = ?, `data_nasc`= ?, `email` = ?, `cpf` = ?, `senha` = ? where `idveterinario`= ? ";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, veterinario.getNome());
		stmt.setInt(2, veterinario.getData_Nasc());
		stmt.setString(3, veterinario.getEmail());
		stmt.setInt(4, veterinario.getCpf());
		stmt.setString(5, veterinario.getSenha());
		stmt.setInt(6, veterinario.getIdveterinario());

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

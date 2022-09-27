package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.mundopet.model.Endereco;



public class EnderecoDao {
	public void AdicionarEndereco(Endereco endereco) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `Endereco`"
				+ "(`idusuario`, `bairro`, `rua`, `cidade`,`numero`, `uf`)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt =  connection.prepareStatement(sql);

		stmt.setInt(1, endereco.getIdUsuario());
		stmt.setString(2, endereco.getBairro());
		stmt.setString(3, endereco.getRua());
		stmt.setString(4, endereco.getCidade());
		stmt.setInt(5, endereco.getNumero());
		stmt.setString(6, endereco.getUf());

		stmt.execute();
		stmt.close();
		connection.close();
	}
	public List<Endereco> ConsultarTodosEnderecos() throws ClassNotFoundException, SQLException{
		Connection connection =  ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idendereco`, `idusuario`, `bairro`, `rua`, `cidade`, `numero`, `uf` FROM `endereco`";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Endereco> listaTodosEnderecos = new ArrayList<Endereco>();

		while(resultSet.next()) {

			Endereco endereco = new Endereco();

			int idenderenco = resultSet.getInt("idendereco");
			endereco.setIdEndereco(idenderenco);
			int idusuario = resultSet.getInt("idusuario");
			endereco.setIdUsuario(idusuario);
			endereco.setBairro(resultSet.getString(3));;
			endereco.setRua(resultSet.getString(4));
			endereco.setCidade(resultSet.getString(5));
			endereco.setNumero(resultSet.getInt(6));
			endereco.setUf(resultSet.getString(7));

			listaTodosEnderecos.add(endereco);
		}
		stmt.close();
		connection.close();

		return listaTodosEnderecos;
	}

	public void AtualizarEndereco (Endereco endereco) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "UPDATE `endereco` set `bairro` = ?, `rua`= ?, `cidade` = ?, `numero` = ?, `uf` = ? where `idendereco`= ? ";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, endereco.getBairro());
		stmt.setString(2, endereco.getRua());
		stmt.setString(3, endereco.getCidade());
		stmt.setInt(4, endereco.getNumero());
		stmt.setString(5, endereco.getUf());
		stmt.setInt(6, endereco.getIdEndereco());

		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

	public void DeletarEndereco( int idendereco) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "DELETE FROM `endereco` WHERE `idendereco`=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(4, idendereco);	

		stmt.executeUpdate();
		stmt.close();
		connection.close();


	}
}

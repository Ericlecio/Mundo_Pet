package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.mundopet.model.Animal;
import br.edu.ifpe.mundopet.model.Consulta;
import br.edu.ifpe.mundopet.model.Usuario;
import br.edu.ifpe.mundopet.model.Veterinario;

@Repository
public class ConsultaDao {
	public void AdicionarConsulta(Consulta consulta) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `Consulta`"
				+ "(`nomeUsuario`,`nomeVeterinario`,`nomeAnimal`, `tipo`, `data_consulta`, `horario`)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, consulta.getNomeUsuario());
		stmt.setString(2, consulta.getNomeVeterinario());
		stmt.setString(3, consulta.getNomeAnimal());
		stmt.setString(4, consulta.getTipo());
		stmt.setDate(5, new Date(consulta.getData_Consulta().getTime()));
		stmt.setString(6, consulta.getHorario());

		stmt.execute();
		stmt.close();
		connection.close();
	}

	public List<Consulta> ConsultarConsultas() throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idconsulta`,`nomeUsuario`,`nomeVeterinario`,`nomeAnimal`, `tipo`, `data_consulta`, `horario` FROM `consulta`";
		;
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Consulta> listaTodasConsulta = new ArrayList<Consulta>();

		while (resultSet.next()) {

			Consulta consulta = new Consulta();

			int idConsulta = resultSet.getInt("idconsulta");
			consulta.setIdconsulta(idConsulta);
			consulta.setNomeUsuario(resultSet.getString(2));
			consulta.setNomeVeterinario(resultSet.getString(3));
			consulta.setNomeAnimal(resultSet.getString(4));
			consulta.setTipo(resultSet.getString(5));
			consulta.setData_Consulta(new java.util.Date(resultSet.getDate(6).getTime()));
			consulta.setHorario(resultSet.getString(7));

			listaTodasConsulta.add(consulta);
		}
		stmt.close();
		connection.close();

		return listaTodasConsulta;
	}

	public void DeletarConsulta(int idconsulta) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "DELETE FROM `consulta` WHERE `idConsulta`=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, idconsulta);

		stmt.executeUpdate();
		stmt.close();
		connection.close();

	}
}

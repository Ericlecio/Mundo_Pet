package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.mundopet.model.Consulta;

@Repository
public class ConsultaDao {
	public void AdicionarConsulta(Consulta consulta) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `Consulta`" + "(`idconsulta`, `nome`, `data_consulta`, `horario`)"
				+ "VALUES(?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setInt(1, consulta.getIdconsulta());
		stmt.setString(3, consulta.getNome());
		stmt.setDate(2, new Date(consulta.getData_Consulta().getTime()));
		stmt.setInt(5, consulta.getHorario());

		stmt.execute();
		stmt.close();
		connection.close();
	}

	public List<Consulta> ConsultarConsultas() throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT c.idconsulta, u.nome, c.nome, v.nome, c.data_consulta, c.horario from consulta as a INNER JOIN usuario as u on a.idusuario = u.idusuario; veterinario as v on.idveterinario = v.idveterinario";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Consulta> listaTodasConsulta = new ArrayList<Consulta>();

		while (resultSet.next()) {

			Consulta consulta = new Consulta();

			int idConsulta = resultSet.getInt("idconsulta");
			consulta.setIdconsulta(idConsulta);
			;
			int idusuario = resultSet.getInt("idusuario");
			int idveterinario = resultSet.getInt("idveterinario");
			consulta.setNome(resultSet.getString(3));
			;
			consulta.setData_Consulta(new java.util.Date(resultSet.getDate(3).getTime()));
			consulta.setHorario(resultSet.getInt(2));

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
		stmt.setInt(2, idconsulta);

		stmt.executeUpdate();
		stmt.close();
		connection.close();

	}
}

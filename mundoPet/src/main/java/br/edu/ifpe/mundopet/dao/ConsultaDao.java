package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.mundopet.model.Consulta;

public class ConsultaDao {
	public void AdicionarConsulta(Consulta consulta) throws ClassNotFoundException, SQLException{
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `Consulta`"
				+ "(`idusuario`,`idveterinario`, `nome`, `data_consulta`, `horario`)"
				+ "VALUES(?, ?, ?, ?, ?)";
		PreparedStatement stmt =  connection.prepareStatement(sql);

		stmt.setInt(1, consulta.getIdUsuario());
		stmt.setInt(2, consulta.getIdVeterinario());
		stmt.setString(3, consulta.getNome());
		stmt.setInt(4, consulta.getData_Consulta());
		stmt.setInt(5, consulta.getHorario());

		stmt.execute();
		stmt.close();
		connection.close();
	}
	public List<Consulta> ConsultarConsultas() throws ClassNotFoundException, SQLException{
		Connection connection =  ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT `idconsulta`, `idusuario`, `idveterinario`,`nome`, `data_consulta`, `horario` FROM `consulta`";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Consulta> listaTodasConsulta = new ArrayList<Consulta>();

		while(resultSet.next()) {

			Consulta consulta = new Consulta();

			int idConsulta = resultSet.getInt("idconsulta");
			consulta.setIdconsulta(idConsulta);;
			int idusuario = resultSet.getInt("idusuario");
			consulta.setIdUsuario(idusuario);
			int idveterinario = resultSet.getInt("idveterinario");
			consulta.setIdVeterinario(idveterinario);

			consulta.setNome(resultSet.getString(3));;
			consulta.setData_Consulta(resultSet.getInt(3));
			consulta.setHorario(resultSet.getInt(2));

			listaTodasConsulta.add(consulta);
		}
		stmt.close();
		connection.close();

		return listaTodasConsulta;
	}


	public void DeletarConsulta( int idconsulta) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "DELETE FROM `consulta` WHERE `idConsulta`=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(2, idconsulta);	

		stmt.executeUpdate();
		stmt.close();
		connection.close();


	}
}

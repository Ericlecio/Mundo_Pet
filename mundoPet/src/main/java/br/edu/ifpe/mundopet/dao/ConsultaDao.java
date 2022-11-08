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
		String sql = "SELECT c.idconsulta, u.nome, a.nome, v.nome, c.nome, c.data_consulta, c.horario from consulta as c INNER JOIN usuario as u on c.idusuario = u.idusuario inner join veterinario as v on c.idveterinario = v.idveterinario inner join animal as a on c.idanimal = a.idanimal;";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Consulta> listaTodasConsulta = new ArrayList<Consulta>();

		while (resultSet.next()) {

			Consulta consulta = new Consulta();
			Usuario usuario = new Usuario();
			Animal animal = new Animal();
			Veterinario veterinario = new Veterinario();
			
			int idConsulta = resultSet.getInt("idconsulta");
			consulta.setIdconsulta(idConsulta);
			usuario.setNome(resultSet.getString(2));
			animal.setNome(resultSet.getString(3));
			veterinario.setNome(resultSet.getString(4));
			consulta.setNome(resultSet.getString(5));
			consulta.setData_Consulta(new java.util.Date(resultSet.getDate(6).getTime()));
			consulta.setHorario(resultSet.getInt(7));
			
			consulta.setAnimal(animal);
			consulta.setUsuario(usuario);
			consulta.setVeterinario(veterinario);

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

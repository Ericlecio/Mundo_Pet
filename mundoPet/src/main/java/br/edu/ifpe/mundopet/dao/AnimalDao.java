package br.edu.ifpe.mundopet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifpe.mundopet.model.Animal;
import br.edu.ifpe.mundopet.model.Usuario;

@Repository
public class AnimalDao {
	public void AdicionarAnimal(Animal animal) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "INSERT INTO `Animal`" + "(`idusuario`, `nome`, `raca`, `idade`,`sexo`)" + "VALUES(?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setInt(1, animal.getUsuario().getIdusuario());
		stmt.setString(2, animal.getNome());
		stmt.setString(3, animal.getRaca());
		stmt.setInt(4, animal.getIdade());
		stmt.setString(5, animal.getSexo());

		stmt.execute();
		stmt.close();
		connection.close();
	}

	public List<Animal> ConsultarTodosAnimais() throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "SELECT a.idanimal, u.nome, a.nome, a.raça, a.idade, a.sexo from animal as a INNER JOIN usuario as u on a.idusuario = u.idusuario;";
		PreparedStatement stmt = connection.prepareStatement(sql);

		ResultSet resultSet = stmt.executeQuery();

		List<Animal> listaTodosAnimais = new ArrayList<Animal>();

		while (resultSet.next()) {

			Animal animal = new Animal();
			Usuario usuario = new Usuario();

			int idAnimal = resultSet.getInt("idanimal");
			animal.setIdAnimal(idAnimal);
			usuario.setNome(resultSet.getString(2));
			animal.setNome(resultSet.getString(3));
			;
			animal.setRaca(resultSet.getString(4));
			animal.setIdade(resultSet.getInt(5));
			animal.setSexo(resultSet.getString(6));

			animal.setUsuario(usuario);

			listaTodosAnimais.add(animal);
		}
		stmt.close();
		connection.close();

		return listaTodosAnimais;
	}

	public void AtualizarAnimais(Animal animal) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "UPDATE `animal` set `nome` = ?, `raca`= ?, `idade` = ?, `sexo` = ?  where `idanimal`= ? ";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, animal.getNome());
		stmt.setString(2, animal.getRaca());
		stmt.setInt(3, animal.getIdade());
		stmt.setString(4, animal.getSexo());
		stmt.setInt(5, animal.getIdAnimal());

		stmt.executeUpdate();
		stmt.close();
		connection.close();
	}

	public void DeletarAnimal(int idanimal) throws ClassNotFoundException, SQLException {
		Connection connection = ConexaoMySQL.getConexaoMySQL();
		String sql = "DELETE FROM `animal` WHERE `idAnimal`=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(4, idanimal);

		stmt.executeUpdate();
		stmt.close();
		connection.close();

	}
}

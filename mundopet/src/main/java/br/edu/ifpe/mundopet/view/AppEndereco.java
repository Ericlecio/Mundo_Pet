package br.edu.ifpe.mundopet.view;


import java.sql.SQLException;
import java.util.List;
import br.edu.ifpe.mundopet.dao.EnderecoDao;
import br.edu.ifpe.mundopet.model.Endereco;

public class AppEndereco {
	public static void main(String[] args) {

		//CONSULTAR

		EnderecoDao enderecoDao = new EnderecoDao();
		try {
			List<Endereco> listaEndereco = enderecoDao.ConsultarTodosEnderecos();
			for (Endereco endereco : listaEndereco) {
				System.out.println("---------------------");
				System.out.println(endereco.getIdEndereco());
				System.out.println(endereco.getIdUsuario());
				System.out.println(endereco.getBairro());
				System.out.println(endereco.getRua());
				System.out.println(endereco.getCidade());
				System.out.println(endereco.getNumero());
				System.out.println(endereco.getUf());
				System.out.println("---------------------");

			}
			enderecoDao.ConsultarTodosEnderecos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//ADICIONAR

		Endereco endereco = new Endereco();

		endereco.setIdUsuario(2);
		endereco.setBairro("nova york");
		endereco.setRua("rua 4");
		endereco.setCidade("nova york");
		endereco.setNumero(111);
		endereco.setUf("SP");

		EnderecoDao enderecodao = new EnderecoDao();

		try {
			enderecodao.AdicionarEndereco(endereco);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		//UPDATE	

		endereco.setBairro("bairro b");
		endereco.setRua("rua a");
		endereco.setCidade("palmares");
		endereco.setNumero(10);
		endereco.setUf("PE");
		endereco.setIdEndereco(4);


		try {
			enderecodao.AtualizarEndereco(endereco);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		//DELETAR

		try {
			enderecodao.DeletarEndereco(4);;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}

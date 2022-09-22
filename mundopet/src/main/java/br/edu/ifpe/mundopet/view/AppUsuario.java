package br.edu.ifpe.mundopet.view;

import java.sql.SQLException;
import java.util.List;
import br.edu.ifpe.mundopet.dao.UsuarioDao;
import br.edu.ifpe.mundopet.model.Usuario;

public class AppUsuario {
	public static void main(String[] args) {
		Usuario usuario = new Usuario();

		usuario.setNome("Vinícius");
		usuario.setData_Nasc(250403);
		usuario.setEmail("aaaaa@gmail.com");
		usuario.setCpf(1234566754);
		usuario.setSenha("senha123");

		UsuarioDao usuarioDao = new UsuarioDao();
		try {
			usuarioDao.adicionarUsuario(usuario);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		UsuarioDao usuariodao = new UsuarioDao();
		try {
			List<Usuario> listaUsuario = usuariodao.consultarTodosUsuarios();
			for (Usuario usuario1 : listaUsuario) {
				System.out.println("---------------------");
				System.out.println(usuario1.getIdusuario());
				System.out.println(usuario1.getNome());
				System.out.println(usuario1.getData_Nasc());
				System.out.println(usuario1.getEmail());
				System.out.println(usuario1.getCpf());
				System.out.println(usuario1.getSenha());
				System.out.println("---------------------");

			}
			//			clienteDao.consultarTodosClientes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

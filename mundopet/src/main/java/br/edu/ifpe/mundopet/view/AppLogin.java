package br.edu.ifpe.mundopet.view;

import java.sql.SQLException;
import br.edu.ifpe.mundopet.dao.LoginDao;
import br.edu.ifpe.mundopet.model.Login;

public class AppLogin {
	public static void main(String[] args) {
		Login login = new Login();
		
		login.setEmail("Vini");
		login.setSenha("vini123");
		
		LoginDao logindao = new LoginDao();
		try {
			logindao.adicionaLogin(login);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

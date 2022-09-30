package br.edu.ifpe.mundopet.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.mundopet.dao.UsuarioDao;
import br.edu.ifpe.mundopet.model.Usuario;


public class UsuarioController {
	@PostMapping("/usuarios")
	public String createUsuario() {
		return "redirect/usuarios";
	}
	
	@GetMapping("/usuarios")
	public ModelAndView index() {
		
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuario=null;
		try {
			usuario = usuarioDao.consultarTodosUsuarios();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("Usuario/usuario");
		mv.addObject("usuarios",usuario);
		return mv;
	}
}

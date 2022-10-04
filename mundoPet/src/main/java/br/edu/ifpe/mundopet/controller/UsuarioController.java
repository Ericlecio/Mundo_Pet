package br.edu.ifpe.mundopet.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.mundopet.dao.UsuarioDao;
import br.edu.ifpe.mundopet.model.Usuario;
@Controller

public class UsuarioController {
	@Autowired
	UsuarioDao usuariodao;

	@PostMapping("/usuarios")
	public String createUsuario() {
		return "redirect:/usuarios";
	}

	@GetMapping("/usuarios")
	public ModelAndView usuario() {

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

		ModelAndView mv = new ModelAndView("usuario/usuario");
		mv.addObject("usuarios",usuario);
		return mv;
	}

	@PostMapping("/clientes")
	public ModelAndView createCliente(@Validated Usuario usuario, BindingResult bindingResults)
	{

		try {
			usuariodao.adicionarUsuario(usuario);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/usuarios") ;
	}

	@GetMapping("usuario/novousuario")
	public ModelAndView novoCliente() { 
		ModelAndView mv = new ModelAndView("usuario/novousuario");
		return mv;
	}
}

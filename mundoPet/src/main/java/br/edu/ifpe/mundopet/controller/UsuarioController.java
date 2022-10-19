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
import br.edu.ifpe.mundopet.util.Util;

@Controller

public class UsuarioController {
	@Autowired
	UsuarioDao usuariodao;

	@GetMapping("/listausuarios")
	public ModelAndView usuario() {

		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuario = null;
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
		mv.addObject("usuarios", usuario);
		return mv;
	}

	@PostMapping("/listausuarios")
	public ModelAndView createUsuario(@Validated Usuario usuario, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("usuario/cadastroUsuario");
			mv.addObject("Usuario", usuario);
			return mv;
		}

		try {
			Util util = new Util();
			String senha = usuario.getSenha();
			usuario.setSenha(util.MD5(senha));
			usuariodao.adicionarUsuario(usuario);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/listausuarios");
	}

	@GetMapping("usuario/cadastroUsuario")
	public ModelAndView novoCliente() {
		ModelAndView mv = new ModelAndView("usuario/cadastroUsuario");
		return mv;
	}
}

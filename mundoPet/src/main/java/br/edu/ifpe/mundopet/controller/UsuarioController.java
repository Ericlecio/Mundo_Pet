package br.edu.ifpe.mundopet.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.mundopet.dao.UsuarioDao;
import br.edu.ifpe.mundopet.model.Usuario;
import br.edu.ifpe.mundopet.util.Util;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioDao usuariodao;

	@GetMapping("/lista/usuarios")
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
		ModelAndView mv = new ModelAndView("Usuario/usuario");
		mv.addObject("usuarios", usuario);
		return mv;
	}

	@PostMapping("/lista/usuarios")
	public ModelAndView createUsuario(@Validated Usuario usuario, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Usuario/cadastroUsuario");
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
		return new ModelAndView("redirect:/lista/usuarios");
	}

	@GetMapping("usuario/cadastroUsuario")
	public ModelAndView novoCliente() {
		ModelAndView mv = new ModelAndView("Usuario/cadastroUsuario");
		return mv;
	}

	@PostMapping("/usuario/{idusuario}/delete")
	public ModelAndView deleteUsuario(@PathVariable Long idusuario) {
		int codigo = (int) idusuario.intValue();
		try {
			usuariodao.DeletarUsuario(codigo);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/lista/usuarios");
	}

	@GetMapping("/usuario/{idusuario}/edit")
	public ModelAndView edit(@PathVariable Long idusuario, Usuario usuario1) {
		ModelAndView mv = new ModelAndView("Usuario/editarUsuario");
		int codigo = (int) idusuario.intValue();
		try {
			usuario1 = usuariodao.consultarUsuarioPorId(idusuario);
			if (usuario1 != null) {
				mv.addObject("usuario", usuario1);
				return mv;
			} else {
				return new ModelAndView("redirect:/lista/usuarios");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mv;
	}

	@PostMapping("/lista/usuarios/{idusuario}")
	public ModelAndView update(@PathVariable Long idusuario, @Validated Usuario usuario, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("usuario/editarUsuario");
			mv.addObject("usuario", usuario);
			return mv;
		} else {
			int codigo = (int) idusuario.intValue();

			try {
				usuario.setIdusuario(codigo);
				usuariodao.AtualizarUsuario(usuario);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/lista/usuarios");
		}
	}

}
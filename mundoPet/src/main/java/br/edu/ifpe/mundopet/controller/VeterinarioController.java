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


import br.edu.ifpe.mundopet.dao.VeterinarioDao;
import br.edu.ifpe.mundopet.model.Usuario;
import br.edu.ifpe.mundopet.model.Veterinario;
import br.edu.ifpe.mundopet.util.Util;


@Controller
public class VeterinarioController {
@Autowired
VeterinarioDao veterinariodao;

	@GetMapping("/veterinarios")
	public ModelAndView veterinario() {
		VeterinarioDao veterinariodao = new VeterinarioDao();
		List<Veterinario> veterinario=null;
		try {
			veterinario = veterinariodao.ConsultarTodosVeterinarios();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("Veterinario/veterinario");
		mv.addObject("veterinarios",veterinario);
		return mv;
	}
	
	@PostMapping("/veterinarios")
	public ModelAndView createVeterinario(@Validated Veterinario veterinario, BindingResult bindingResults){
			if(bindingResults.hasErrors()) {
				ModelAndView mv = new ModelAndView("Veterinario/cadastroVeterinario");
				mv.addObject("Veterinario", veterinario);
				return mv;
			}
		try {
			Util util = new Util();
			String senha = veterinario.getSenha();
			veterinario.setSenha(util.MD5(senha));
			veterinariodao.AdicionarVeterinario(veterinario);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/veterinarios") ;
	}

	@GetMapping("Veterinario/cadastroVeterinario")
	public ModelAndView cadastroVeterinario() { 
		ModelAndView mv = new ModelAndView("Veterinario/cadastroVeterinario");
		return mv;
	}
}


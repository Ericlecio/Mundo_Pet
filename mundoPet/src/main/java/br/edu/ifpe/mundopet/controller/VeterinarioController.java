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
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.mundopet.dao.VeterinarioDao;
import br.edu.ifpe.mundopet.model.Usuario;
import br.edu.ifpe.mundopet.model.Veterinario;
import br.edu.ifpe.mundopet.util.Util;

@Controller
public class VeterinarioController {
	@Autowired
	VeterinarioDao veterinariodao;

	@GetMapping("/lista/veterinarios")
	public ModelAndView veterinario() {
		VeterinarioDao veterinariodao = new VeterinarioDao();
		List<Veterinario> veterinario = null;
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
		mv.addObject("veterinarios", veterinario);
		return mv;
	}

	@PostMapping("/lista/veterinarios")
	public ModelAndView createVeterinario(@Validated Veterinario veterinario, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
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

		return new ModelAndView("redirect:/lista/veterinarios");
	}

	@GetMapping("veterinario/cadastroVeterinario")
	public ModelAndView cadastroVeterinario() {
		ModelAndView mv = new ModelAndView("Veterinario/cadastroVeterinario");
		return mv;
	}
	
	@PostMapping("/veterinario/{idveterinario}/delete")
	public ModelAndView deleteVeterinario(@PathVariable Long idveterinario) {
		int codigo = (int) idveterinario.intValue();
		try {
			veterinariodao.DeletarVeterinario(codigo);
			
		} catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/lista/veterinarios");
	}
	
	@GetMapping("/veterinario/{idveterinario}/edit")
	public ModelAndView edit (@PathVariable Long idveterinario, Veterinario veterinario1) {
		ModelAndView mv = new ModelAndView("Usuario/editarUsuario");
		int codigo = (int) idveterinario.intValue();
		try {
			veterinario1 = veterinariodao.consultarVeterinarioPorId(idveterinario);
			if(veterinario1 != null) {
				mv.addObject("veterinario", veterinario1);
				return mv;
			}else {
				return new ModelAndView("redirect:/lista/veterinarios");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mv;
}
	@PostMapping("/lista/veterinarios/{idveterinario}")
	public ModelAndView update(@PathVariable Long idveterinario, @Validated Veterinario veterinario, BindingResult bindingResults) {
		
		if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("veterinario/editarVeterinario");
			mv.addObject("veterinario", veterinario);
			return mv;
		} else {
			int codigo = (int) idveterinario.intValue();
			
			try {
				veterinario.setIdveterinario(codigo);
				veterinariodao.AtualizarVeterinario(veterinario);
			}catch (ClassNotFoundException | SQLException e){
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/lista/usuarios");
		}
	}
}

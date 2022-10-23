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

import br.edu.ifpe.mundopet.dao.ConsultaDao;
import br.edu.ifpe.mundopet.model.Consulta;

@Controller

public class ConsultaController {
	@Autowired
	ConsultaDao consultadao;

	@GetMapping("/lista/consultas")
	public ModelAndView consulta() {

		ConsultaDao consultadao = new ConsultaDao();
		List<Consulta> consulta = null;
		try {
			consulta = consultadao.ConsultarConsultas();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("Consulta/Consulta");
		mv.addObject("consultas", consulta);
		return mv;
	}

	@PostMapping("/lista/consultas")
	public ModelAndView createConsulta(@Validated Consulta consulta, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Consulta/cadastroConsulta");
			mv.addObject("Consulta", consulta);
			return mv;
		}

		try {
			consultadao.AdicionarConsulta(consulta);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/lista/consultas");
	}

	@GetMapping("Consulta/cadastroConsulta")
	public ModelAndView cadastroConsulta() {
		ModelAndView mv = new ModelAndView("Consulta/cadastroConsulta");
		return mv;
	}
}

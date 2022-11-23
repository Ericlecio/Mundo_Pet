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

import br.edu.ifpe.mundopet.dao.AnimalDao;
import br.edu.ifpe.mundopet.dao.EnderecoDao;
import br.edu.ifpe.mundopet.model.Endereco;

@Controller
public class EnderecoController {
	@Autowired
	EnderecoDao enderecodao;

	@GetMapping("/lista/enderecos")
	public ModelAndView endereco() {

		EnderecoDao enderecodao = new EnderecoDao();
		List<Endereco> endereco = null;
		try {
			endereco = enderecodao.ConsultarTodosEnderecos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("Endereco/endereco");
		mv.addObject("enderecos", endereco);
		return mv;
	}

	@PostMapping("/lista/enderecos")
	public ModelAndView createEndereco(@Validated Endereco endereco, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Endereco/cadastroEndereco");
			mv.addObject("Endereco", endereco);
			return mv;

		}
		EnderecoDao enderecodao = new EnderecoDao();

		try {
			enderecodao.AdicionarEndereco(endereco);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/lista/enderecos");
	}

	@GetMapping("Endereco/cadastroEndereco")
	public ModelAndView cadastroEndereco() {
		ModelAndView mv = new ModelAndView("Endereco/cadastroEndereco");
		return mv;
	}
	
	
	@PostMapping("/endereco/{idendereco}/delete")
	public ModelAndView deleteEndereco(@PathVariable Long idendereco) {
		int codigo = (int) idendereco.intValue();
		try {
			enderecodao.DeletarEndereco(codigo);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/lista/enderecos");
	}
}

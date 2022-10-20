package br.edu.ifpe.mundopet.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.mundopet.dao.EnderecoDao;
import br.edu.ifpe.mundopet.model.Endereco;
import br.edu.ifpe.mundopet.model.Usuario;

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
		mv.addObject("enderecos",endereco);
		return mv;
	}
	@PostMapping("/lista/enderecos")
	public ModelAndView createEndereco(@Validated Endereco endereco, BindingResult bindingResults){
		if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Endereco/cadastroEndereco");
			mv.addObject("Endereco", endereco);
			return mv;
		}
		try {
			//mock
			Usuario usuario =new Usuario();
			usuario.setNome("fulano");
			endereco.setIdUsuario(0);
			enderecodao.AdicionarEndereco(endereco);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/lista/enderecos") ;
	}
	@GetMapping("Endereco/cadastroEndereco")
	public ModelAndView novoEndereco() { 
		ModelAndView mv = new ModelAndView("Endereco/cadastroEndereco");
		return mv;
	}
}

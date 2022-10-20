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
import br.edu.ifpe.mundopet.model.Animal;
import br.edu.ifpe.mundopet.model.Usuario;
import br.edu.ifpe.mundopet.model.Veterinario;

@Controller
public class AnimalController {
	@Autowired
	AnimalDao animaldao;

	@GetMapping("/listaanimais")
	public ModelAndView animal() {
		
		AnimalDao animaldao = new AnimalDao();
		List<Animal> animal = null;
		try {
			animal = animaldao.ConsultarTodosAnimais();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("animal/animal");
		mv.addObject("animais",animal);
		return mv;
	}
	@PostMapping("/listaanimais")
	public ModelAndView createAnimal(@Validated Animal animal, BindingResult bindingResults){
		if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Animal/newAnimal");
			mv.addObject("animal", animal);
			return mv;
		}
		try {
			//mock
			Usuario usuario =new Usuario();
			usuario.setNome("fulano");
			animal.setUsuario(usuario);
			animaldao.AdicionarAnimal(animal);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/listaanimais") ;
	}
	@GetMapping("Animal/cadastroAnimal")
	public ModelAndView newAnimal() { 
		ModelAndView mv = new ModelAndView("Animal/newAnimal");
		return mv;
	}
}

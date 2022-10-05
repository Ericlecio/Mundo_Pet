package br.edu.ifpe.mundopet.controller;

import java.sql.SQLException;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.mundopet.dao.AnimalDao;
import br.edu.ifpe.mundopet.model.Animal;

@Controller
public class AnimalController {
	
//	@PostMapping("/animal")
//	public String createAnimal() {
//		return "redirect/animal";
//	}
	
	@GetMapping("/animais")
	public ModelAndView animal() {
		
		AnimalDao animaldao = new AnimalDao();
		List<Animal> animais = null;
		try {
			animais = animaldao.ConsultarTodosAnimais();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("Animal/animal");
		mv.addObject("animais",animais);
		return mv;
	}
}


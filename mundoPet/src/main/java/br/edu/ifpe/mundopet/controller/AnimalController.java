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
import br.edu.ifpe.mundopet.model.Endereco;


@Controller
public class AnimalController {
	@Autowired
	AnimalDao animaldao;

	@GetMapping("/lista/animais")
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
		mv.addObject("animais", animal);
		return mv;
	}

	@PostMapping("/lista/animais")
	public ModelAndView createAnimal(@Validated Animal animal, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Animal/cadastroAnimal");
			mv.addObject("Animal", animal);
			return mv;
		}
		try {

			animaldao.AdicionarAnimal(animal);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/lista/animais");
	}

	@GetMapping("animal/cadastroAnimal")
	public ModelAndView novoAnimal() {
		ModelAndView mv = new ModelAndView("Animal/cadastroAnimal");
		return mv;
	}
	
	

	@PostMapping("/animal/{idanimal}/delete")
	public ModelAndView deleteAnimal(@PathVariable Long idanimal) {
		int codigo = (int) idanimal.intValue();
		try {
			animaldao.DeletarAnimal(codigo);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/lista/animais");
	}

	@GetMapping("/animal/{idanimal}/edit")
	public ModelAndView edit(@PathVariable Long idanimal, Animal animal1) {
		ModelAndView mv = new ModelAndView("Animal/editarAnimal");
		int codigo = (int) idanimal.intValue();
		try {
			animal1 = animaldao.consultarAnimalPorId(idanimal);
			if (animal1 != null) {
				mv.addObject("animal", animal1);
				return mv;
			} else {
				return new ModelAndView("redirect:/lista/animais");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mv;
	}

	@PostMapping("/lista/animais/{idanimal}")
	public ModelAndView update(@PathVariable Long idanimal, @Validated Animal animal, BindingResult bindingResults) {
		if (bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("Animal/editarAnimal");
			mv.addObject("animal", animal);
			return mv;
		} else {
			int codigo = (int) idanimal.intValue();

			try {
				animal.setIdAnimal(codigo);
				animaldao.AdicionarAnimal(animal);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return new ModelAndView("redirect:/lista/animais");
		}
	}
}

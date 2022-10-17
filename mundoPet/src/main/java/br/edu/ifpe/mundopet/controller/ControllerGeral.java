package br.edu.ifpe.mundopet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerGeral {

	@GetMapping("/home")
	public ModelAndView home() { 
		ModelAndView mv = new ModelAndView("html/telaPrincipal");
		return mv;
	}
	
	
}

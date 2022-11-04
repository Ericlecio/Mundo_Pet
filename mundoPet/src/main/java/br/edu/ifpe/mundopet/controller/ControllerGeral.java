package br.edu.ifpe.mundopet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerGeral {

	@GetMapping("/MundoPet")
	public ModelAndView pagina1() {
		ModelAndView mv = new ModelAndView("Html/telaPrincipal");
		return mv;
	}
	@GetMapping("/sistema")
	public ModelAndView sistema() {
		ModelAndView mv = new ModelAndView("Html/home");
		return mv;
	}
    @GetMapping("/menu")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("Html/menu");
		return mv;
	}
}

package br.edu.ifpe.mundopet.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpe.mundopet.dao.UsuarioDao;
import br.edu.ifpe.mundopet.model.Usuario;
import br.edu.ifpe.mundopet.util.Util;
import br.edu.ifpe.mundopet.model.Login;

@RestController
@Controller
public class LoginController {

	@Autowired
	UsuarioDao usuariodao;
	
	@Autowired
	
    private Login login;
	private User user;
	
	@GetMapping("/login")
	public ModelAndView Login() { 
		ModelAndView mv = new ModelAndView("usuario/Login");
		return mv;
	}
	
	
	
	@PostMapping("/login")
	public ModelAndView validateUsuario(@Validated Usuario usuario, BindingResult bindingResults)
	{
		if(bindingResults.hasErrors()) {
			ModelAndView mv = new ModelAndView("usuario/Cadastro");
			mv.addObject("Usuario", usuario);
			return mv;
		}

		try {
			Util util = new Util();
			String senha = usuario.getSenha();
			usuario.setSenha(util.MD5(senha));
			
			usuariodao.consultarUsuariosEmailSenha(usuario);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/usuarios") ;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView novoCliente() { 
		ModelAndView mv = new ModelAndView("usuario/Cadastro");
		return mv;
	}
	
    private Usuario usuario;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Usuario>login(@RequestBody @Validated Usuario usuario,
                                           HttpSession session) {
        User user = login.getUsuario(usuario.getEmail());

        session.setAttribute("email", email);
        Senha senha = new D((User) session.getAttribute("user"));
        return ResponseEntity.ok(dataUser);
    }
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/signIn", method = RequestMethod.POST)
    public ResponseEntity<DataUser> signIn(@RequestBody @Valid SignInUser signInUser,
                                           HttpSession session) {
        User user = login.getUser(signInUser.getEmail(), signInUser.getPassword());
        session.setAttribute("user", user);
        DataUser dataUser = new DataUser((User) session.getAttribute("user"));
        return ResponseEntity.ok(dataUser);
    }

	
}


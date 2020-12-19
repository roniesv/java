package com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caelum.agenda.dao.JdbcUsuarioDao;
import com.caelum.agenda.modelo.Usuario;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) throws ClassNotFoundException {
		if (new JdbcUsuarioDao().existeUsuario(usuario)) {
			
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm";
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}

}

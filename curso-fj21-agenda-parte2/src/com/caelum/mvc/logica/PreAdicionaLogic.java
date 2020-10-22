package com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PreAdicionaLogic implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "/WEB-INF/jsp/Adiciona-contato2.jsp";
	}
	

}

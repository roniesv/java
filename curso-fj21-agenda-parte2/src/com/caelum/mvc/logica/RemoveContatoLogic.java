package com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.agenda.dao.ContatoDao;
import com.caelum.agenda.modelo.Contato;

public class RemoveContatoLogic implements Logica{
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDao dao = new ContatoDao();
		dao.remove(contato);
		
		System.out.println("Excluindo contato...");
		return "mvc?logica=ListaContatosLogic";
		
	}
	

}

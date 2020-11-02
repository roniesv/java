package com.caelum.mvc.logica;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.agenda.dao.ContatoDao;
import com.caelum.agenda.modelo.Contato;

public class PreAlteracaoLogic implements Logica {			
			
			public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
				
				long id = Long.parseLong(req.getParameter("id"));
				
				Contato contato = new Contato();
				contato.setId(id);
				Connection connection = ((Connection)req.getAttribute("conexao"));

				ContatoDao dao = new ContatoDao(connection);
				contato = dao.localizaIntId(id);
				req.setAttribute("contato", contato);
				
				return "/WEB-INF/jsp/altera-contato.jsp";
			}
			
		}
	
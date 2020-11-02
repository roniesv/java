package com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.agenda.dao.ContatoDao;
import com.caelum.agenda.modelo.Contato;
public class AlteraContatoLogic implements Logica{
	
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//long id = Long.parseLong(req.getParameter("id"));
	   
	   try {
			Connection connection = ((Connection)req.getAttribute("conexao"));
   
		ContatoDao dao = new ContatoDao(connection);		
		Contato contato = new Contato();
//		contato.setId(id);
//		contato = dao.localizaIntId(id);
	    contato.setId(Long.parseLong(req.getParameter("id")));
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		String dataEmTexto = req.getParameter("dataNascimento");
		Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = null;
		
		dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		contato.setDataNascimento(dataNascimento);
		dao.altera(contato);
		
		System.out.println("Alterando contato...");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
		}
	   
		return "mvc?logica=ListaContatosLogic";

	}

}

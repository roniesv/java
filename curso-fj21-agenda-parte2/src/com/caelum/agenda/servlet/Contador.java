package com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caelum.agenda.dao.ContatoDao;
import com.caelum.agenda.modelo.Contato;

@WebServlet("/contador")
public class Contador extends HttpServlet{
	private int contador = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		contador++;
		PrintWriter out = resp.getWriter();
		//out.println("Contador agore é: "+contador);
		
		
			ContatoDao dao;
			Connection connection = ((Connection)req.getAttribute("conexao"));

			List<Contato> contatos = new ArrayList<Contato>();

			
			try {
				dao = new ContatoDao(connection);
				contatos = dao.getLista();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			out.println("<html>");
			out.println("<body> ");
			
			for(Contato contato: contatos) {
				
				out.println("<br>Nome: "+contato.getNome());
				out.println("<br>Email: "+contato.getEmail()); 
				out.println("<br>Endereço: "+contato.getEndereco());
			    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			    String data = df.format(contato.getDataNascimento().getTime());
				out.println("<br>Data de Nascimento: "+data+"<br>");
				
				
			}
			out.println("</body>");
			out.println("</html>");
			
		

	}

}

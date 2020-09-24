package com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		name="OiServlet5",
		urlPatterns = {"/oi5"},
		initParams = {
				@WebInitParam(name="param1", value="Ronie"),
				@WebInitParam(name="param2", value="Programador")
		}
)

public class OiServletComParam extends HttpServlet{
	private String nome;
	private String profissao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.nome = config.getInitParameter("param1");
		this.profissao = config.getInitParameter("param2");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Servlet com paramentros</h1>");
			out.println("Nome: "+nome);
			out.println("<br>Profissão: "+profissao);
			out.println("</body>");
			out.println("</html>");
	}
	

}

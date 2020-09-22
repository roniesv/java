package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet (
	name = "OiServlet6",
	urlPatterns = {"/oi6"},
	initParams = {
			@WebInitParam(name="param1", value="Angelina"),
			@WebInitParam(name="param2", value="Bisavó")
	}
	
)
public class OiServletComParam2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h2>Exemplo com InitParm Servlet</h2>");
		ServletConfig config = getServletConfig();
		
		String parametro1 = config.getInitParameter("param1");
		out.println("Valor do parâmentro 1: "+parametro1);
		
		String parametro2 = config.getInitParameter("param2");
		out.println("<br>Valor do parâmetro 2: "+parametro2);
		
		out.close();
		
		
	}

}

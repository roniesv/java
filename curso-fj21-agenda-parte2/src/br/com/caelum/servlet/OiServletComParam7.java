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
@WebServlet(
	name="OiServlet7",
	urlPatterns = {"/oi7"},

		initParams = {
				@WebInitParam(name="param1", value="Jó"),
				@WebInitParam(name="param2", value="Velho Testamento")
		}
)
public class OiServletComParam7 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("Text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<h2>Exemplo com InitParm Servlet</h2>");
		
		out.println("Valor do parâmentro 1: "+getServletConfig().getInitParameter("param1"));
		
		out.println("Valor do parâmentro 2: "+getServletConfig().getInitParameter("param2"));
		
		out.close();
	}

	

}

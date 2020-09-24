package com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minhaServlet")
public class MinhaServlet extends HttpServlet {
	
	 public void init(ServletConfig config) throws ServletException{
		 super.init(config);
		 log("Iniciando a servlet");
	 }
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>Minha servlet usando metodo init e destroy </body>");
		out.println("</html>");
		
	}

}

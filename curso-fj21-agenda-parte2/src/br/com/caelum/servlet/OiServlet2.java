package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// servlets 3.0 anotações, evita usar o web.xml mais prático
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oi2")//equivalente url-pattern , tbm tem o paramentro name, por padrão o fullname, mas pode especificar.

public class OiServlet2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	
	out.println("<html>");
	out.println("<body>");
	out.println("<h1>Servlet 3.0</h1>");
	out.println("<p>Páginas dinâmica gerada com o servlet 3.0 anotações</>");
	out.println("</body>");
	out.println("</html>");
	
	
	}
	
}
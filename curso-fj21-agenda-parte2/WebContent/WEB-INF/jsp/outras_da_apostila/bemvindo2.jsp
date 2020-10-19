<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bem vindo</title>
</head>
<body>
	<%--comentários em JSP aqui: nossa primeira JSP --%>
	<%
		String mensagem = "Bem vindo ao sistema de agenda de fj21!";
	%>
	<%
		out.println(mensagem);
	%>
	<br/>
	<% String desenvolvido = "Desenvolvido por Ronie"; %>
	<%=desenvolvido %>
	<br>
	<%System.out.println("Tudo foi executado!"); %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP</title>
</head>
<body>
	
	<%String mensagem = "Bem vindo"; String mensagem2="Fim";%>
	<%out.println(mensagem); %>
	
	JSP é muito parecido com html mesmo os comandos javas começa a parecer tags.
	<%--Podemos escrever nos esp --%>
	<%= mensagem2 %>
	
</body>
</html>
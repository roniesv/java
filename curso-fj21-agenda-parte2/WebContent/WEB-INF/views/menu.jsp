<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>P�gina Inicial</title>
</head>
<body>
  <a href ="logout">Sair do sistema</a>
  <h2>P�gina inicial da Lista de Tarefas</h2>
  <p>Bem vindo, ${usuarioLogado.login}</p>
  <a href="listaTarefas">Clique aqui</a> para acessar a lista tarefas
  
  
</body>
</html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de tarefas</title>
</head>
<body>
	<h3>Adicionar Tarefas</h3>
	
xe   <form:errors path="tarefa.descricao"/>
	<form action="adicionaTarefa" method="post">
		Descrição: <br/>
		<textarea name="descricao" rows="5" cols="100"> </textarea><br/>
		<input type="submit" value="Adicionar">
	</form>
</body>
</html>

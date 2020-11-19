<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="/css/jquery-ui.css" type= "text/css" rel="stylesheet">


<meta charset="UTF-8">
<title>Alterar Tarefas</title>
</head>
<body>

	<h3>Alterar tarefa - ${tarefa.id}</h3>
	<form action="alteraTarefa" method="post">
	   <input type="hidden" name="id" value="${tarefa.id}">
	   
	   Descrição:<br/>
	   <textarea name="descricao" cols="100" rows="5">
	   		<%-- --%>${tarefa.descricao}<%-- --%>
	   </textarea>
	   <br/>
	   Finalizado? <input type="checkbox" name="finalizado" value="true" 
	   ${tarefa.finalizado? 'checked':''}/><br/>
	   Data de finalização: <br/>
	   
<!-- 	   <input type="text" name="dataFinalizacao" -->
<%-- 	   value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" --%>
<%-- 	   pattern="dd/MM/yyyy"/>"> --%>


	   <caelum:campoData id="dataFinalizacao" />
	   <br/>
	   <input type="submit" value="Alterar">
	</form>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery-ui.js"></script>
</body>
</html>
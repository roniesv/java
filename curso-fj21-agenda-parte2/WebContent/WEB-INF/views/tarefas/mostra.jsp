<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<!DOCTYPE html>
<html>
<head>

<link href="<c:url value="resources/css/jquery-ui.css"/>" rel="stylesheet">
<script src="<c:url value="resources/js/jquery.js"/>"/></script>
<script src="<c:url value="resources/js/jquery-ui.js"/>"/></script>

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

</body>
</html>
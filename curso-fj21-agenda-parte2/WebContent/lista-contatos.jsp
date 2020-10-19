<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista contatos jsp e jstl</title>
</head>
<body>
    <c:import url="cabecalho.jsp"/>
	<jsp:useBean id="dao" class="com.caelum.agenda.dao.ContatoDao"/>
    <table border=1>
    	<tr>
    			<th>Nº</th>
    			<th>Nome</th>
    	    	<th>Email</th>
    	    	<th>Endereço</th>
    	    	<th>Data de Nascimento</th>
    	 </tr>
    	<c:forEach var="contato" items="${dao.lista}" varStatus="id">
    	    
    	    <tr bgcolor="#${id.count%2 == 0 ?'aaee88':'ffffff'}">
    	      <td>${id.count}</td>
    	      <td>${contato.nome}</td>
    	      <td>
    	         <c:choose>
    	            <c:when test="${not empty contato.email}">
    	            <a href="mailto:${contato.email}">${contato.email}</a>
    	            </c:when>
    	            <c:otherwise>
    	            	E-mail não informado
    	            </c:otherwise>
    	         </c:choose>
    	      </td>
    	      <td>${contato.endereco}</td>
    	      <td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
    	      <td>
    	      	<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
    	      </td>
    	    </tr>	
    	</c:forEach>
    </table>
    <c:import url="rodape.jsp"/>
</body>
</html>
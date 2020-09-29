<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista contatos jsp e jstl</title>
</head>
<body>
	<jsp:useBean id="dao" class="com.caelum.agenda.dao.ContatoDao"/>
    <table border=1>
    	<tr>
    			<th>N�</th>
    			<th>Nome</th>
    	    	<th>Email</th>
    	    	<th>Endere�o</th>
    	    	<th>Data de Nascimento</th>
    	 </tr>
    	<c:forEach var="contato" items="${dao.lista}" varStatus="id">
    	    
    	    <tr bgcolor="#${id.count%2 == 0 ?'aaee88':'ffffff'}">
    	      <td>${id.count}</td>
    	      <td>${contato.nome}</td>
    	      <td>
    	         <c:if test="${not empty contato.email}">
    	            <a href="mailto:${contato.email}">${contato.email}</a>
    	         </c:if>
    	         <c:if test="${empty contato.email}">
    	         	E-mail n�o informado
    	         </c:if>
    	      </td>
    	      <td>${contato.endereco}</td>
    	      <td>${contato.dataNascimento.time}</td>
    	    </tr>	
    	</c:forEach>
    </table>
</body>
</html>
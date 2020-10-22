<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alteração de Contato</title>
</head>
<body>
    <form action="mvc?logica=AlteraContatoLogic">
    	Id:<input type="text" name="nome" value="${contato.id}" /></br>
		Nome:<input type="text" name="nome" value="${contato.nome}" /></br> 
		Email:<input type="text" name="email" value = "${contato.email}" /></br> 
		Endereço:<input type="text" name="endereco" value="${contato.endereco}"/></br>
		<input type="text" name="dataNascimento" value="<fmt:formatDate value='${contato.dataNascimento.time}' pattern="dd/MM/yyyy"/>" placeholder="dataNascimento" /><br>
        <input type="submit" value="Alterar"/>  
	</form>

</body>
</html>
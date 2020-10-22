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
    <!--  so funciona com o metodo post o get da erro  -->
    <form action="mvc?logica=AdicionaContatoLogic" method="post">
    	Id:<input type="text" name="id"/></br>
		Nome:<input type="text" name="nome"/></br> 
		Email:<input type="text" name="email"/></br> 
		Endereço:<input type="text" name="endereco"/></br>
		<input type="text" name="dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy"/>" placeholder="dataNascimento" /><br>
        <input type="submit" value="Alterar"/>  
	</form>

</body>
</html>
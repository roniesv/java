<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Contato Agenda</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>
<h1>Adiciona Contatos</h1>
<form action="adicionaContato">
	Nome:<input type="text" name="nome"/></br>
	Email:<input type="text" name="email"/></br>
	Endereço:<input type="text" name="endereco"/></br>
	DataNascimento:<input type="text" name="dataNascimento"/></br>
	<input type="submit" value="Gravar"/>
</form>

<c:import url="rodape.jsp"/>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE html>
<html>

<head>
<link href="jquery-ui.css" rel="stylesheet">
<script src="jquery-ui.js"></script>
<meta charset="UTF-8">
<title>Adiciona Contato Agenda</title>
<link href="jquery-ui.css" rel="stylesheet">
<script src="jquery.js"></script>

<script src="jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h1>Adiciona Contatos</h1>
	<form action="adicionaContato">
		Nome:<input type="text" name="nome" /></br> Email:<input type="text"
			name="email" /></br> Endereço:<input type="text" name="endereco" /></br>
		DataNascimento:
		<caelum:campoData id="dataNascimento" />
		</br> <input type="submit" value="Gravar" />
	</form>

	<c:import url="rodape.jsp" />
</body>
</html>
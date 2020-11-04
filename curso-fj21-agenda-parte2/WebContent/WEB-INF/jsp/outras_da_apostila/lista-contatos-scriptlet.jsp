<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.text.*,java.sql.Connection, com.caelum.agenda.dao.*,com.caelum.agenda.modelo.*, com.caelum.agenda.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista contatos scriptlet</title>
</head>
<body>
	<table>
	<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Email</th>
		<th>Endereço</th>
		<th>Data Nascimento</th>
	</tr>
	<%
	    Connection conn = new ConnectionFactory().getConnection();
		ContatoDao dao = new ContatoDao(conn);
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = dao.getLista();
		for(Contato contato: contatos){
	%>
	
	<tr>
		<td><%=contato.getId() %>
		<td><%=contato.getNome()%> </td>
		<td><%=contato.getEmail() %></td>
		<td><%=contato.getEndereco() %></td>
		
		<%
		 SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 String dataformatada = df.format(contato.getDataNascimento().getTime());
		 
		%>
		<td><%=dataformatada %></td>
	</tr>
	
	<% 
		}
	%>
	</table>

</body>
</html>
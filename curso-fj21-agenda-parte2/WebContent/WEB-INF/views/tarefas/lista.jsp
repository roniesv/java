<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
       <script type="text/javascript" src="resources/js/jquery.js"></script>
     </head>

<head>
<meta charset="UTF-8">
<title>Lista de Tarefas</title>
</head>
<body>
  <script type="text/javascript">
     function finalizaAgora(id){
    	 $.post("finalizaTarefa", {'id' : id}, function(){
    		 //selecionando o elemento html através da 
    		 //id e alterando o html dele
    		 $("#tarefa_"+id).html("Finalizado");
    	 });
     }
     
     function removeTarefa(id){
    	 $.post("removeTarefa1", {'id': id}, function(){
    		 $("td").closest("tr").hide();
    	 });
    	 
     }
  
  </script>
 
  
  
  
  
  
  	<a href="novaTarefa">Criar nova</a>
	<br/><br/>
	<table>
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de Finalização</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
		   <tr>
		   	  <td>${tarefa.id}</td>
		   	  <td>${tarefa.descricao}</td>
		   	  <c:if test="${tarefa.finalizado eq false}">
		   	     <td id="tarefa_${tarefa.id}">
		   	     	<a href="#" onclick="finalizaAgora(${tarefa.id})">
		   	     	Finaliza agora!
		   	     	</a>
		   	     </td>
		   	  </c:if>
		   	  <c:if test="${tarefa.finalizado eq true}">
		   	     <td>Finalizado</td>
		   	  </c:if>
		   	  <td>
		   	  
    	               <fmt:formatDate
    	                  value="${tarefa.dataFinalizacao.time}"
    	                  pattern="dd/MM/yyyy"/>
    	           
    	        	 </td>
    	        	 <td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
    	       <td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
    	       <td><a href="#" onClick="removeTarefa(${tarefa.id})">Excluir</a></td>
    			
    	    </tr>
		</c:forEach>	
	</table>
	



</body>
</html>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Adiciona Tarefas</title>
</head>
<body>

	<form action="tarefaController" method="post">
		<label for="descricaco">Descrição:</label>
		<input type="text" name="descricao" id="descricao" /><br />
		<label for="finalizado">Finalizado?
			<input type="checkbox" name="finalizado" value="true"  />
		</label><br />
					
		<label for="dataFinalizacao">Data da Finalização</label>
		<input type="text" name="dataFinalizado" id="dataFinalizacao" /><br />
		<button type="submit">Adicionar</button>

	</form>
<jsp:useBean id="dao" class="br.com.csi.dao.TarefaDao" />
<table>
	<thead><tr> <td>Tarefas</td> </tr></thead>
	<tbody>
		<tr>
			
			<th>Descrição</th>
			<th>Finalizado</th>
			<th>Data Finalização</th>
		</tr>
	<c:forEach var="tarefa" items="${dao.tarefas}">
	
		<tr>
			<td>${tarefa.descricao}</td>
			<td>${tarefa.finalizado}</td>			
			<td>
				<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
			</td>
		</tr>
	
	</c:forEach>
	
	</tbody>
</table>

</body>
</html>
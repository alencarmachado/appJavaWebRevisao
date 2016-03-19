<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<!DOCTYPE html>

<head>
  	<meta charset="utf-8">
	<title>Adiciona Tarefas</title>
	<link href=<c:url value="css/bootstrap.min.css"/> rel="stylesheet"> 
    <script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>


</head>
<body>

	<jsp:include page="cabecalho.jsp" />

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
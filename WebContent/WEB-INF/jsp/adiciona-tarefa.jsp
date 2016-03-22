<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>

<head>
<meta charset="utf-8">
<title>Adiciona Tarefas</title>
<link href=<c:url value="recursos/css/bootstrap.min.css"/> rel="stylesheet">
<script type="text/javascript" src="recursos/js/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="recursos/js/bootstrap.min.js"></script>


</head>
<body>


	<jsp:include page="cabecalho.jsp" />

	<c:choose>
		<c:when test="${tarefa.id != null }">
			<h2>Alterar Tarefa</h2>
		</c:when>
		<c:otherwise>
			Adicionar Tarefa
		</c:otherwise>
	</c:choose>

	<section>			
		<form action="tarefaController" method="post">
		<input type="hidden" name="id_alterar" value="${tarefa.id}" />
			<fieldset>
				<div class="form-group">
					<label for="descricaco">Descrição:</label>
					<textarea rows="5" cols="100" id="descricao" name="descricao"
						class="form-control">${tarefa.descricao}</textarea>
				</div>
				<div class="form-group">
					<label for="finalizado">Finalizado? <input type="checkbox"
						name="finalizado" value="true" />
					</label><br />
				</div>
				<div class="form-group">
					<label for="dataFinalizacao">Data da Finalização</label> 
						<input type="text"class="form-control" id="dataFinalizacao" name="dataFinalizacao" value=" <fmt:formatDate 
					value="${tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy" /> "  />
				</div>
			</fieldset>
			<button type="submit" class="btn btn-default">Adicionar</button><br />
		</form>			
	</section>	
	
	<section>
		
		<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<tr>
				<th>Descrição</th>
				<th>Finalizado</th>
				<th>Data Finalização</th>
				<th>Ações</th>
			</tr>
	 
		</thead>
		<tfoot>
			<tr>
				<tr>
				<th>Descrição</th>
				<th>Finalizado</th>
				<th>Data Finalização</th>
				<th>Ações</th>
			</tr>
		</tfoot>
		<tbody>
			
			<c:forEach var="tarefa" items="${tarefas}">
				<tr>
					<td>${tarefa.descricao}</td>
					<td>${tarefa.finalizado}</td>
					<td><fmt:formatDate value="${tarefa.dataFinalizacao.time}"
							pattern="dd/MM/yyyy" />
					</td>
					<td>
						<a class="btn btn-danger" href="http://localhost:8080/appJavaWebRevisao/tarefaController?buscarTarefa=true&&id=${tarefa.id}">Alterar</a>
						<a class="btn btn-danger" href="http://localhost:8080/appJavaWebRevisao/tarefaController?removeTarefa=true&&id=${tarefa.id}" >Remover</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>		
		
	</section>



	

</body>
</html>
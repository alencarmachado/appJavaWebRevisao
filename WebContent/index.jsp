<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<link rel="stylesheet" href="recursos/css/bootstrap.css">

</head>
<body>

	<div class="jumbotron">
		<div class="container">
			<h1>Bem vindo ao Sistema de Revisão de Java Web</h1>
			<p>Estude bastante.. não existe outra auternativa</p>
		</div><!-- fim container -->
	</div><!-- fim jumbotron -->

	<div class="container">
	
		<!-- 
Repare que cada campo possui um input e um label. Para agrupá-los, usamos um div form-group do Bootstrap. Cada input deve ter uma classe form-control.
 -->
	<form action="usuarioController" method="post">
	
	<fieldset>
			<div class="form-group">			
				<legend>Logar no Sistema</legend>
				<label for="login">Login:</label>
				<input type="text" name="login" id="login" value="mariana" autofocus="autofocus" placeholder="login" class="form-control" required /> <br />
			</div>
			<div class="form-group">			
				<label for="senha">Senha</label>		
				<input type="password" name="senha" value="123" id="senha" placeholder="senha" class="form-control" required/><br />	
			</div>
	
	</fieldset>			
		<button type="submit" class="btn btn-primary">
		LOGAR</button>
	</form>


	<c:if test="${not empty msg}">
		<h2> Usuário ou Senha não cadastrado</h2>
	</c:if>
	
	</div>


</body>
</html>
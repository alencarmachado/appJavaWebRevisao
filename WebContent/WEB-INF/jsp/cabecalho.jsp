
	<div class="container">
      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a style="color: blue" class="navbar-brand" href="#">Bem vindo(a) 
            
            	${sessionScope['usuarioLogado'].login }
            
            </a>
          </div><!-- fim navbar -->
          
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="http://localhost:8080/appJavaWebRevisao/WEB-INF/jsp/principal.jsp">Home</a></li>
             
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastro <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="http://localhost:8080/appJavaWebRevisao/tarefaController">Tarefas</a></li>
                  <li><a href="#">....</a></li>
                  <li><a href="#">....</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Administrativo</li>
                  <li><a href="#">Usuários</a></li>
                  <li><a href="#">...</a></li>
                </ul>
              </li>
               <li><a href="#">Sobre</a></li>
              <li><a href="http://localhost:8080/appJavaWebRevisao/LogoutServlet">LOGOUT</a></li>
            </ul>
            <!-- <ul class="nav navbar-nav navbar-right">
              <li class="active"><a href="./">Default <span class="sr-only">(current)</span></a></li>
              <li><a href="../navbar-static-top/">Static top</a></li>
              <li><a href="../navbar-fixed-top/">Fixed top</a></li>
            </ul> -->
          </div><!--/.nav-collapse -->
          
        </div><!--/.container-fluid -->
      </nav>

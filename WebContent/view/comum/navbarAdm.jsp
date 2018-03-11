<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<c:import url="/view/linkcss.jsp" />
	<c:import url="../css/css_navbar.jsp" />
</head>
<nav class="navbar  navbar-fixed-top navbar-expand-lg "navbar navbar-light" style="background-color: #277554;">

  <a class="navbar-brand" href="#">uevents</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       Usuário
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Novo usuário</a>
          <a class="dropdown-item" href="#">Alterar usuário</a>
          <a class="dropdown-item" href="#">Excluir usuário</a>
          
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Evento
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Novo evento</a>
          <a class="dropdown-item" href="#">Alterar evento</a>
          <a class="dropdown-item" href="#">Excluir evento</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Nova atividade</a>
      </li>
    </ul>
                  <button class="btn btn-success pull-right" href="logout.php">Sair</button>
                
   
  </div>
</nav>
</html>

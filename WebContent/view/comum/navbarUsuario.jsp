	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<c:import url="../css/css_navbar.jsp" />
</head>

<nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #277554;">
  <a class="navbar-brand" href="desistir">Uevents</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
    <c:if test="${usuarioLogado.idTipoUsuario == 3}">
      <li class="nav-item active">
        <a class="nav-link" href="cadasAtividade">Nova Atividade</a>
      </li>
    </c:if>
     <li class="nav-item active">
        <a class="nav-link"href="desistir">Pagina Inicial</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link"href="exibirAlterarUsuario">Alterar Dados</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link"href="exibirAlterarSenha">Alterar Senha</a>
      </li>
    </ul>
  </div>
  <a href="logout"><button class="btn btn-success pull-right">Sair</button></a>
</nav>
 
	

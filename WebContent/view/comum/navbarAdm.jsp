 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<c:import url="../css/css_navbar.jsp" />
</head>

<nav class="navbar navbar-expand-lg navbar-dark " style="background-color: #277554;">
  <a class="navbar-brand" href="paginaInicial">Uevents</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
	     <li class="nav-item active">
	        <a class="nav-link" href="paginaInicial">Página Inicial</a>
	      </li>
      <c:if test="${usuarioLogado.id != 1}">
	      <li class="nav-item active">
	        <a class="nav-link" href="cadasAtividade">Nova Atividade</a>
	      </li>
	  <li class="nav-item active">
        <a class="nav-link"href="exibirAlterarUsuario">Alterar dados</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link"href="exibirAlterarSenha">Alterar senha</a>
      </li>
      </c:if>
       <c:if test="${usuarioLogado.id == 1}">
      <li class="nav-item active">
        <a class="nav-link"href="/uevents/cadasProf">Novo usuário</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/uevents/cadasEvento">Novo evento</a>
      </li>
       <li class="nav-item active">
        <a class="nav-link" href="/uevents/cadasAtividade">Nova Atividade</a>
      </li>
      </c:if>
    </ul>
  </div>
<a href="logout"><button class="btn btn-success pull-right">Sair</button></a>
</nav>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:if test="${msg != null}">
						<!-- Alterar porta do tomcat -->
		<meta http-equiv="Refresh" content="3;url=http://localhost:8081/uevents/pagianInicial">
	</c:if>
	<title>Alterar Dados</title>
	<c:import url="/view/linkcss.jsp" />
    <script type="text/javascript">
      function verificaSenha(){
    	var senha = document.getElementById("senha");
        var confSenha = document.getElementById("confSenha");

        if(senha.value!=confSenha.value){
           alert("As senhas não combinam");
           confSenha.focus();
           return false;
          }
        }
    </script>
</head>
<body>
<c:import url="../comum/navbarAlteraSenha.jsp" />
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-20 p-b-20">
				<form class="login100-form validate-form" action="alterarSenha" method="post" onsubmit="return verificaSenha();">
					<span class="login100-form-title p-b-20">
						UEVENTS
					</span>
					<c:if test="${msg != null }">
						<div class="alert alert-success">
						      <button type="button" class="close" aria-hidden="true">×</button>
						      <span><strong> Parabéns:</strong> ${msg} </span>
						</div>
					</c:if>
					<input type="hidden" name="id" value="${usuarioLogado.id}">
					<div class="wrap-input100 validate-input m-b-30" data-validate="Escreva sua senha">
						<input class="input100" type="password" name="senha" id="senha">
						<span class="focus-input100" data-placeholder="Senha"></span>
					</div>
					<div class="wrap-input100 validate-input m-b-30" data-validate="Escreva novamento sua senha">
						<input class="input100" type="password" id="confSenha" name="confSenha">
						<span class="focus-input100" data-placeholder="Confimar de senha"></span>
					</div>
					<input class="input100" type="hidden" name="idTipoUsuario" value="${usuarioLogado.idTipoUsuario}">
					<br>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Alterar
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
  <c:import url="/view/linkjs.jsp" />
</body>
</html>
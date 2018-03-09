<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${msg != null}">
	<meta http-equiv="Refresh" content="3;url=http://localhost:8080/uevents/">
</c:if>
<title>UEVENTS</title>
<c:import url="/view/linkcss.jsp" />
</head>
<body>
<c:import url="../comum/navbarCadas.jsp" />
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-20 p-b-20">
				<form class="login100-form validate-form" action="inserirUsuario" method="post">
					<span class="login100-form-title p-b-20">
						UEVENTS
					</span>
					<c:if test="${msg != null }">
						<div class="alert alert-success">
						      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
						      <span><strong> Parabéns:</strong> ${msg} </span>
						</div>
					</c:if>
					<div class="wrap-input100 validate-input m-b-35" data-validate = "Escreva seu nome">
						<input class="input100" type="text" name="nome">
						<span class="focus-input100" data-placeholder="Nome"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-35" data-validate = "Escreva seu CPF">
						<input class="input100" type="text" name="cpf">
						<span class="focus-input100" data-placeholder="CPF"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-35" data-validate = "Escreva seu e-mail">
						<input class="input100" type="text" name="email">
						<span class="focus-input100" data-placeholder="E-mail"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-35" data-validate="Escreva uma senha">
						<input class="input100" type="password" name="senha">
						<span class="focus-input100" data-placeholder="Senha"></span>
					</div>
					<select class="wrap-input100 validate-input m-b-20" name="idTipoUsuario">
						<option>Selecione o tipo de usuário...</option>
						<option value="1">Convidado</option>
						<option value="2">Aluno</option>
					</select>
					<br>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Cadastrar
						</button>
					</div>

					<ul class="login-more p-t-12">
						<li>
							<span class="txt1">
								Já tem conta?
							</span>

							<a href="/uevents" class="txt2">
								Clique aqui!
							</a>
						</li>
					</ul>
				</form>
			</div>
		</div>
	</div>
	
		<div id="dropDownSelect1"></div>
<c:import url="/view/linkjs.jsp" />
	

</body>
</html>

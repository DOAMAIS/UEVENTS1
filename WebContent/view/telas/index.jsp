<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UEVENTS</title>
<c:import url="/view/linkcss.jsp" />



</head>

<body>
<c:import url="../comum/navbar.jsp" />
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form action="efetuaLogin" method="post" class="login100-form validate-form">
					<span class="login100-form-title p-b-70"> UVENTS </span>
					<!-- Teste de alerta, qualquer coisa é só tirar -->
					<c:if test="${msg != null }">
						<div class="alert alert-danger">
					      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					      <span><strong> Erro:</strong> ${msg} </span>
					    </div>
					</c:if>
					<!-- Teste de alerta, qualquer coisa é só tirar -->
					<div class="wrap-input100 validate-input m-t-85 m-b-35"
						data-validate="Enter username">
						<input class="input100" type="text" name="cpf"> <span
							class="focus-input100" data-placeholder="CPF"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-50"
						data-validate="Enter password">
						<input class="input100" type="password" name="senha"> <span
							class="focus-input100" data-placeholder="Senha"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">ENTRAR</button>
					</div>

					<ul class="login-more p-t-50">
						<li class="m-b-8">
							<a href="#" class="txt2"> Esqueceu a senha?</a>
						</li>

						<li><span class="txt1"> Não tem conta? </span>
							<a href="cadasUsuario" class="txt2"> Clique aqui!</a>
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


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UEVENTS</title>
<c:import url="/view/linkcss.jsp" />
<c:import url="../comum/navbar.jsp" />

</head>
<body>

<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-25 p-b-20">
				<form class="login100-form validate-form" action="inserirUsuario" method="post">
					<span class="login100-form-title p-b-20">
						UEVENTS
					</span>
					</span>
					 <c:if test="${mensagem != null }">
						<div class="alert alert-success"> 
					      <button type="button" class="close" data-dismiss="alert" aria-hidden="true" >×</button>
					      <span> ${mensagem} </span>
					    </div>
					</c:if>
					
					<div class="wrap-input100 validate-input m-b-35" data-validate = "Enter matriculation">
						<input class="input100" type="text" name="nome">
						<span class="focus-input100" data-placeholder="Nome"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-35" data-validate = "Enter matriculation">
						<input class="input100" type="text" name="cpf">
						<span class="focus-input100" data-placeholder="CPF"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-35" data-validate = "Enter email">
						<input class="input100" type="text" name="email">
						<span class="focus-input100" data-placeholder="E-mail"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-35" data-validate="Enter password">
						<input class="input100" type="password" name="senha">
						<span class="focus-input100" data-placeholder="Senha"></span>
					</div>
					<select class="wrap-input100 validate-input m-b-35" name="idTipoUsuario">
						<option>Selecione o tipo de usuário...</option>
						<option value="1">Convidado</option>
						<option value="2">Aluno</option>

					</select>
				
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Cadastrar
						</button>
					</div>

					<ul class="login-more p-t-15">
						<li>
							<span class="txt1">
								Já tem conta?
							</span>

							<a href="uevents" class="txt2">
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

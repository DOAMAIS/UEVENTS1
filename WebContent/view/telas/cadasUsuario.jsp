<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UEVENTS</title>
<c:import url="/view/link.jsp" />
<c:import url="../comum/navbar.jsp" />

</head>
<body>

<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-70">
						UEVENTS
					</span>
					
					<div class="wrap-input100 validate-input m-b-35" data-validate = "Enter matriculation">
						<input class="input100" type="text" name="matriculation">
						<span class="focus-input100" data-placeholder="Matrícula"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-35" data-validate = "Enter email">
						<input class="input100" type="text" name="email">
						<span class="focus-input100" data-placeholder="E-mail"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-35" data-validate="Enter password">
						<input class="input100" type="password" name="pass">
						<span class="focus-input100" data-placeholder="Senha"></span>
					</div>
					<select class="form-control">
						<option>Selecione o tipo de usuário...</option>
						<option value="1">Aluno</option>
						<option value="2">Convidado</option>
						<option value="3">Professor</option>
					</select>
					<br>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>

					<ul class="login-more p-t-190">
						<li>
							<span class="txt1">
								Já tem conta?
							</span>

							<a href="/index.jsp" class="txt2">
								Clique aqui!
							</a>
						</li>
					</ul>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
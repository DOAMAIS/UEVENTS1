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
<title>Cadastre-se</title>
<c:import url="/view/linkcss.jsp" />
<script src="/view/js/jquery.js"></script>
<script src="/view/js/jquery.validate.js"></script>
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
      
      function letras(){
    	  var tecla = event.keyCode;
    	  if (tecla >= 33 && tecla <= 64 || tecla >= 91 && tecla <= 93 || tecla >= 123 && tecla <= 159 || tecla >= 162 && tecla <= 191 ){ 
    	      return false;
    	  }else{
    	     return true;
    	  }
    	}
      
      function formatar(mascara, documento){
    	    var i = documento.value.length;
    	    var saida = mascara.substring(0,1);
    	    var texto = mascara.substring(i)
    	    if (texto.substring(0,1) != saida){
    	        documento.value += texto.substring(0,1);
    	    }
    	}
      
	function validar(dom,tipo){
		switch(tipo){
			case'num':var regex=/[A-Za-zçãàáâéêíóôõúÂÃÁÀÉÊÍÓÔÕÚÇ<\>\!?$%:;,º°ª]/g;break;
			case'text':var regex=/\d/g;break;
		}
		dom.value=dom.value.replace(regex,'');
	}
      $(function() {
    	  $("form").validate({
    		  rules: {
    			  nome: {
    				  required : true
    			  }
    			  
    		  	}
    	  });
      });
  </script>

</head>
<body>

<c:import url="../comum/navbar.jsp" />
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-40 p-b-20">
				<form class="login100-form validate-form" action="inserirUsuario" method="post" onsubmit="return verificaSenha();">
					<span class="login100-form-title p-b-20">
						UEVENTS
					</span>
					<c:if test="${msg != null}">
						<div class="alert alert-success">
						      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
						      <span><strong> Parabéns:</strong> ${msg} </span>
						</div>
					</c:if>
					<div class="wrap-input100 validate-input m-b-35" data-validate = "Escreva seu nome">
						<input class="input100" type="text" id="nome" name="nome" onkeypress="return letras();">
						<span class="focus-input100" data-placeholder="Nome"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-35" data-validate = "Escreva seu CPF">
						<input class="input100" type="text" id="cpf" name="cpf" onkeyup="validar(this,'num');" OnKeyPress="formatar('###.###.###-##', this);" minlength="14" maxlength="14">
						<span class="focus-input100" data-placeholder="CPF"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-35" data-validate = "Escreva seu e-mail">
						<input class="input100" type="email" id="email" name="email">
						<span class="focus-input100" data-placeholder="E-mail"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-30" data-validate="Escreva sua senha">
						<input class="input100" type="password" name="senha" minlength="5" id="senha">
						<span class="focus-input100" data-placeholder="Senha"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-30" data-validate="Escreva novamento sua senha">
						<input class="input100" type="password" id="confSenha" name="confSenha">
						<span class="focus-input100" data-placeholder="Confimar de senha"></span>
					</div>
					<select class="wrap-input100 validate-input m-b-20" name="idTipoUsuario"  required>
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

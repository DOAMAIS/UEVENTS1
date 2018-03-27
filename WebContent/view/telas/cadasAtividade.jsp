<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!-- Taglibs -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- /Taglibs -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Atividades</title>
	<script type="text/javascript">
		function restantes(id){
			var a = document.getElementById(id);
			b =a.value.length;
			document.getElementById("i").innerHTML = "Restam "+(150-b)+" caracteres";

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
			case'num':var regex=/[A-Za-zçãàáâéêíóôõúÂÃÁÀÉÊÍÓÔÕÚÇ<\>\!?$%;,º°ª]/g;break;
			case'text':var regex=/\d/g;break;
		}
		dom.value=dom.value.replace(regex,'');
	}
	</script>
	<style type="text/css">
		#card {
		      max-width: 390px;
		      padding: 40px 40px;
		      background-color: #F7F7F7;
		      padding: 20px 25px 30px;
		      margin: 0 auto 25px;
		      margin-top: 70px;
		      -moz-border-radius: 2px;
		      -webkit-border-radius: 2px;
		      border-radius: 5px;
		      -webkit-box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.3);
		      box-shadow: 2px 2px 3px rgba(0, 0, 0, 0.3);
		}		      
		 .widget {
			  background-color: #FFF;
			  width:400px;
			  margin:50px auto 0;
			  padding:20px 30px;
			  box-shadow:0 10px 20px rgba(0, 0, 0, 0.30	);
			  border-left: 5px solid #5cb85c;
			  position:absolute;
			  left:38%;
		  	  top:5%;
		}     

	</style>
	<c:import url="/view/linkcss.jsp" />
	<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../comum/navbarAdm.jsp" />
	<div class="widget">
	<c:if test="${msg != null}">
		<div class="alert alert-success">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
			<span><strong> Parabéns:</strong> ${msg} </span>
		</div>
	</c:if>
	<form action="inserirAtividade" method="post" enctype="multipart/form-data">
	  <h2>Nova Atividade</h2>
	 	<select class="form-control" name="id_evento">
	 		<option>Selecione o Evento</option>
	 	<c:if test="${not empty lista}">
	 <c:forEach var="evento" items="${lista}">
	 		<option value="${evento.id}">${evento.nome}</option>
	 </c:forEach>
	 	</c:if>
	 	</select><br/>
	 	<input type="hidden" name="id_orientador" value="${usuarioLogado.id}"/>
		<input type="text" class="form-control" placeholder="Nome da Atividade" name="nome" minlength="5" required/><br/>
		<input type="text" class="form-control" name="orientador" placeholder="Orientador da Atividade" minlength="5" required/><br/>
		<input type="text" class="form-control" name="data"  placeholder="11/07/2001 - data da atividade" minlength="10" maxlength="10" OnKeyPress="formatar('##/##/####', this)" onkeyup="validar(this,'num');" required/><br/>
		<input type="text" class="form-control" name="horaInicio" placeholder="13:00 - hora de inÃ­cio"  minlength="5"  maxlength="5" OnKeyPress="formatar('##:##', this)" onkeyup="validar(this,'num');" required/> &nbsp; &nbsp; &nbsp;
		<input type="text" class="form-control" name="horaTermino" placeholder="13:00 - hora de termino" minlength="5"  maxlength="5"  OnKeyPress="formatar('##:##', this)" onkeyup="validar(this,'num');" required/><br/>
		<input type="text" class="form-control" name="local" placeholder="Local da Atividade" required/><br/>
	  	<textarea class="form-control" name="descricao" id="descricao"placeholder="DescriÃ§Ã£o da Atividade" maxlength="150" onkeydown="restantes(this.id);"></textarea>
	  	<i id="i"></i><br>
	  	<input type="text" class="form-control" placeholder="ObservaÃ§Ã£o(opcional)" name="observacao"/><br/>
	  	<input type="number" class="form-control" placeholder="Limite de Pessoas" name="limite" required/><br/>
	  	<button class="btn btn-success">Nova Atividade</button>
	</form>
	
</body>
</html>

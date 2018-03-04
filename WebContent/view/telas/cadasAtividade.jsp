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
	<link rel="stylesheet" type="text/css" href="view/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../comum/navbarUsuario.jsp" />
	<div class="widget">
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
		<input type="text" class="form-control" placeholder="Nome da Atividade" name="nome" minlength="5" required/><br/>
		<input type="text" class="form-control" name="orientador" placeholder="Orientador da Atividade" minlength="5" required/><br/>
		<input type="text" class="form-control" name="data"  placeholder="11/07/2001 - data do evento" required/><br/>
		<input type="text" class="form-control" name="horaInicio" placeholder="13:00 - hora de início" required/> &nbsp; &nbsp; &nbsp;
		<input type="text" class="form-control" name="horaTermino" placeholder="13:00 - hora de término" required/><br/>
		<input type="text" class="form-control" name="local" placeholder="Local da Atividade" required/><br/>
	  	<textarea class="form-control" name="descricao" id="descricao"placeholder="Descrição da Atividade" maxlength="150" onkeydown="restantes(this.id);"></textarea>
	  	<i id="i"></i><br>
	  	<input type="text" class="form-control" placeholder="Observação(opcional)" name="observacao"/><br/>
	  	<input type="number" class="form-control" placeholder="Limite de Pessoas" name="limite" required/><br/>
	  	<button class="btn btn-success">Nova Atividade</button>
	</form>
	
</body>
</html>
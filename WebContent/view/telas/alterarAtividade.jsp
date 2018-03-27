<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!-- Taglibs -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- /Taglibs -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alterar Atividade</title>
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
	<form action="alteracaoEfetuada" method="post" enctype="multipart/form-data">
	  <h2>Alterar Atividade</h2>
	 	<select class="form-control" name="id_evento">
	 		<option>Selecione o Evento</option>
		 	<c:if test="${not empty lista}">
			  <c:forEach var="evento" items="${lista}">
			 		<option <c:if test="${atividade.id_evento == evento.id}">selected</c:if> value="${evento.id}">${evento.nome}</option>
			  </c:forEach>
		 	</c:if>
	 	</select><br/>
	 	<input type="hidden" name="id" value="${atividade.id}"/>
		<input type="text" class="form-control" value="${atividade.nome }" placeholder="Nome da Atividade" name="nome" minlength="5" required/><br/>
		<input type="text" class="form-control" value="${atividade.orientador }" name="orientador" placeholder="Orientador da Atividade" minlength="5" required/><br/>
		<input type="text" class="form-control" value="<fmt:formatDate value="${atividade.data}" pattern="dd/MM/yyyy"/>" name="data"  placeholder="11/07/2001 - data do evento" minlength="10" maxlength="10" OnKeyPress="formatar('##/##/####', this)" required/><br/>
		<input type="text" class="form-control" value="${atividade.horaInicio }" name="horaInicio" placeholder="13:00 - hora de inÃ­cio" minlength="5"  maxlength="5" OnKeyPress="formatar('##:##', this)" required/> &nbsp; &nbsp; &nbsp;
		<input type="text" class="form-control" value="${atividade.horaTermino }" name="horaTermino" placeholder="13:00 - hora de tÃ©rmino" minlength="5"  maxlength="5" OnKeyPress="formatar('##:##', this)" required/><br/>
		<input type="text" class="form-control" value="${atividade.local }" name="local" placeholder="Local da Atividade" required/><br/>
	  	<textarea class="form-control" name="descricao" id="descricao" placeholder="DescriÃ§Ã£o da Atividade" maxlength="150" onkeydown="restantes(this.id);">${atividade.descricao}</textarea>
	  	<i id="i"></i><br>
	  	<input type="text" class="form-control" value="${atividade.observacao }" placeholder="ObservaÃ§Ã£o(opcional)" name="observacao"/><br/>
	  	<input type="number" class="form-control" value="${atividade.limite }" placeholder="Limite de Pessoas" name="limite" required/><br/>
	  	<button class="btn btn-success">ALTERAR</button>
	</form>
	
</body>
</html>

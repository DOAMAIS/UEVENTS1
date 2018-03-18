<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Eventos</title>
	<script type="text/javascript">
		function restantes(id){
			var a = document.getElementById(id);
			b =a.value.length;
			document.getElementById("i").innerHTML = "Restam "+(150-b)+" caracteres";
		}
	</script>
	<style type="text/css">
		#card {
		      max-width: 350px;
		      padding: 40px 40px;
		      background-color: #F7F7F7;
		      padding: 20px 25px 30px;
		      margin: 0 auto 25px;
		      margin-top: 70px;
		      -moz-border-radius: 2px;
		      -webkit-border-radius: 2px;
		      border-radius: 5px;
		      -webkit-box-shadow: 0px 1px 1px rgba(0, 0, 0, 0.3);
		      box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.3);
    	}
	    .widget {
			  background-color: #FFF;
			  width:400px;
			  margin:50px auto 0;
			  padding:20px 30px;
			  box-shadow:0 10px 20px rgba(0, 0, 0, 0.30);
			  border-left: 5px solid #5cb85c;
			  position:absolute;
			  left:38%;
			  top:20%;
		}
	</style>
	<c:import url="/view/linkcss.jsp" />
	<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../comum/navbarEvento.jsp" />
 <div class="container">
  <div class="widget">
	<form action="inserirEvento" method="post" enctype="multipart/form-data">
	  <h2>Novo Evento</h2>
	  <input type="hidden" name="status" value="ativo"/>
		<input type="text" class="form-control" placeholder="Nome do Evento" name="nome" minlength="5" required/><br/>
		<input type="file" class="form-control" name="file" accept=".jpeg,.png,.jpg"/><br/>
		<input type="text" class="form-control" name="dataInicio" placeholder="11/07/2001 - data de início" minlength="5" required/><br/>
		<input type="text" class="form-control" name="dataTermino" placeholder="11/07/2001 - data de término" minlength="5" required/><br/>
	  	<textarea class="form-control" name="descricao" id="descricao"placeholder="Descrição da Atividade" maxlength="150" onkeydown="restantes(this.id);"></textarea>
	  	<label align="left" id="i"></label><br>
	  	<button class="btn btn-success">Novo Evento</button>

	</form>
   </div>		
  </div>	
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>UEVENTS</title>
	<c:import url="/view/linkcss.jsp" />
    <link rel="stylesheet" href="/view/bootstrap/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="/view/bootstrap/js/bootstrap.min.js"></script>

<style>
<!-- Bora tirar esses CSS's daqui -->
		html, body {
		  background-color: #FFF;
		  color: #666;
		  font-family: sans-serif;
		}
		.widget {
		  background-color: #FFF;
		  width:400px;
		  margin:50px auto 0;
		  padding:20px 30px;
		  box-shadow:0 0 20px rgba(0, 0, 0, 0.15);
		  border-left: 5px solid #5cb85c;
		}
		.widget input[type=text] {
		  border: 1px solid #eee;
		  padding: 5px;
		  color: #666;
		  width:100%;
		}
		.widget .row {
		  width:100%;
		  margin-bottom:10px;
		  clear:both;
		}
		.widget .left {
		  width:200px;
		  float:left;
		  padding-top:5px;
		}
		.widget .right {
		  float:left;
		}
		.widget .result {
		  width:200px;
		  float:right;
		  padding:5px 10px;
		  text-align:center;
		  color:#FFF;
		  text-shadow:0 -1px 0 rgba(0, 0, 0, 0.25);
		  border: 1px solid #eee;
		  cursor: pointer;
		  background-color:#4EBADA;
		  background: linear-gradient(#4EBADA 10%, #3C8EA7) repeat scroll 0 0 transparent;
		}
		.invalid .widget {
		  border-left: 5px solid #ed3737;
		}
		.invalid .widget .result {
		  background-color:#ed3737;
		  background: linear-gradient(#ed3737 10%, #dc2626) repeat scroll 0 0 transparent; 
		}

</style>
</head>

<body>
<c:import url="../comum/navbarUsuario.jsp" />
	<div class="container">
 		<div class="widget">
		  <h1>${atvEscolhida.nome}</h2>
		  <div class="row">
		    <div class="left">
		       <label for="card">Data: <fmt:formatDate value="${atvEscolhida.data}" pattern="dd/MM/yyyy"/></label>
		       <label for="card"> Horário: ${atvEscolhida.horaInicio}</label>
		       <label for="card"> Ministrada por: ${atvEscolhida.orientador}</label>
		    </div>
		  </div>
		  
		  <div class="row">
		 
			    <a class="btn btn-success" href="participacaoConfirmada?id=${atvEscolhida.id}">Confirmar</a> &nbsp; &nbsp;
			    <a class="btn btn-danger" href="desistir">Cancelar</a>
		
		  </div>
		  
		</div>
		<br/><br/>
  
 	</div> 
 	
 	<c:import url="/view/linkjs.jsp" />
</body>
</html>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visualisar Evento</title>
	<c:import url="/view/link.jsp" />
	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<style type="text/css">	
	
			p{
				
			}
			.custab{
			    border: 1px solid #ccc;
			    padding: 5px;
			    margin: 5% 0;
			    box-shadow: 3px 3px 2px #ccc;
			    transition: 0.5s;
			    }
			.custab:hover{
			    box-shadow: 3px 3px 0px transparent;
			    transition: 0.5s;
			    }
			 #q{
			    border: 1px solid black;
			    color: red;
			    background-color:black;
			    height: 1px;
			    width: 100%;
			 }
			#eventdi{
			 background-color: white;
			 padding: 20px;
			 border: 2px solid black;
			 border-color:black;
			}
			hr{
				border-color:black;
			}
	</style>
</head>
<body>
  <div class="limiter">
     <div class="container-login100">
		<div class="wrap-login100 p-t-85 p-b-20">
			<span class="login100-form-title p-b-70">
				  Bem vindo!
			</span>
      
			  <c:forEach var="evento" items="${listaEventos}">
			      <div id="eventdi">
			      <div id="eventdiv">
			      	  <c:choose>
			      	  	<c:when test="${not empty evento.foto }">
			      	  		<img src="view/img/eventos/${evento.foto}" height="50" width="50">
			      	  	</c:when>
			      	  	<c:otherwise>
			      	  		<img src="view/img/123.png" height="70" width="70">
			      	  	</c:otherwise>
			      	  </c:choose>
					     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					     	<b>${evento.nome}</b><br><hr>
					      	<p style="color:black;">${evento.descricao}</p>
			   	  </div>
							<hr id="q">	
					<table class="table table-striped custab">
			    		<thead>
			  		        <tr>
					            <th>Atividades</th>
					            <th>Data</th>
					            <th>Hora</th>
					        </tr>
			    		</thead>
			    		<c:forEach var="atividade" items="${listaAtividades}">
				    		<c:if test="${evento.id == atividade.id_evento }">
					            <tr>
					                <td>${atividade.nome}</td>
					                <td><fmt:formatDate value="${atividade.data}" pattern="dd/MM/yyyy"/></td>
					                <td>${atividade.horaInicio}</td>
					            </tr>
					        </c:if>
			            </c:forEach>
				  </table>
				  </div>
				  <br/>
			</c:forEach>
		</div>
    </div>
 </div>
</body>
</html>
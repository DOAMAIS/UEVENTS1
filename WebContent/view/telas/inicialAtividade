<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <c:import url="/view/link.jsp" />
	<c:import url="../comum/navbar.jsp" />
	
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
  <div class="limiter">
     <div class="container-login100">
        <div class="wrap-login100 p-t-85 p-b-20">
            <span class="login100-form-title p-b-70">
                  Bem vindo Nome do usuario!
            </span>
           <a href="inicialEvento" class="button">Evento</a>           
            
            <div id="Atividades" >
             <table class="table table-striped custab">
                        <thead>
                            <tr>
                                <th>Atividades</th>
                                <th></th>
                            </tr>
                        </thead>
                        <c:forEach var="atividade" items="${listaAtividades}">
                            <c:if test="${evento.id == atividade.id_evento }">
                                <tr>
                                    <td>${atividade.nome}</td>
                                    <td><button class="buttonb">Cancelar</button></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                  </table>
         </div>
        </div>
    </div>
 </div>

    <div id="dropDownSelect1"></div>
    

</body>
</html>

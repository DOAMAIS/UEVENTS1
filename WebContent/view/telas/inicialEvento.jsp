<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
	<c:import url="/view/linkcss.jsp" />
    <c:import url="../comum/navbar.jsp" />
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
    

	  <script type="text/javascript">
      function Mudarestado(Atividades, Eventos) {
        var display = document.getElementById(Atividades).style.display;
        if(display == "none"){
            document.getElementById(Atividades).style.display = 'block';
             document.getElementById(Eventos).style.display= 'none';
        }else{
            document.getElementById(Atividades).style.display = 'none';
           document.getElementById(Eventos).style.display = 'block';
        }
    }


   
  </script> 

    <style type="text/css"> 


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
    .button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 09px 21px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
#eventdiv{
 background-color: white;
 border: 1px solid;
 border-color:#4CAF50;
}
   .custab{
                border: 1px solid #ccc;
                padding: 5px;
                margin: 5% 0;
                box-shadow: 3px 3px 2px #ccc;
                transition: 0.5s;
                }
            
            
            #eventdi{
             background-color: white;
            border-radius: 25px;
             padding: 20px; 
            width: 600px;
             border: 2px solid #73AD21;
              height: 325px; 
             
            }
                

            hr{
                border-color:#4CAF50;;
            }
            .button {
    background-color: #4CAF50; 
    padding: 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 3px 1px;
    cursor: pointer;
}
.button1 {border-radius: 12px;}

.buttona {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 05px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 3px 1px;
    cursor: pointer;
}
.buttonb {
    background-color: #FF0000;
    border: none;
    color: white;
    padding: 05px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 3px 1px;
    cursor: pointer;
}

</style>

  <script type="text/javascript">
      function Mudarestado(Atividades, Eventos) {
        var display = document.getElementById(Atividades).style.display;
        if(display == "none"){
            document.getElementById(Atividades).style.display = 'block';
             document.getElementById(Eventos).style.display= 'none';
        }else{
            document.getElementById(Atividades).style.display = 'none';
           document.getElementById(Eventos).style.display = 'block';
        }
    }


   
  </script>  
</head>
<body>
  <div class="limiter">
     <div class="container-login100">
        <div class="wrap-login100 p-t-85 p-b-20">
            <span class="login100-form-title p-b-70">
                  Bem vindo Nome do usuario!
            </span>
           <button class="button button1" onclick="Mudarestado('Eventos', 'Atividades')">Evento</button> 
           <button class="button button1" onclick="Mudarestado('Eventos','Atividades')">Minhas atividades</button>
           <div  id="Eventos" style="display: block;">
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
                                <th></th>
                            </tr>
                        </thead>
                        <c:forEach var="atividade" items="${listaAtividades}">
                            <c:if test="${evento.id == atividade.id_evento }">
                                <tr>
                                    <td>${atividade.nome}</td>
                                    <td><fmt:formatDate value="${atividade.data}" pattern="dd/MM/yyyy"/></td>
                                    <td>${atividade.horaInicio}</td>
                                    <td><button class="buttona button1">Participar</button>
                                </tr>
                            </c:if>
                        </c:forEach>
                  </table>
                  </div>
                  <br/>
            </c:forEach>
            </div>
            <div id="Atividades" style="display: none;">
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
                                    <td><button class="buttonb button1">Cancelar</button></td>
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
   

   

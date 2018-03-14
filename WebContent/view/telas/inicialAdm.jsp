<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <title>Visualizar Eventos</title>
    <c:import url="/view/linkcss.jsp" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/view/bootstrap/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="/view/bootstrap/js/bootstrap.min.js"></script>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
     <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
    


    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="/view/bootstrap/js/bootstrap.min.js"></script>
    
</head>
<body>
<c:import url="../comum/navbarAdm.jsp" />
<br><br><br>
<div class="container">   
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <!-- Nav tabs category -->
            <div class="center"><h1>Bem vindo !</h1></div>
            <ul class="nav nav-tabs faq-cat-tabs">
                <li class="active"><a href="#faq-cat-1" data-toggle="tab">Eventos</a></li>
               
            </ul>
    
            <!-- Tab panes / começo -->
            <div class="tab-content faq-cat-content">
                <div class="tab-pane active in fade" id="faq-cat-1">
                    <div class="panel-group" id="accordion-cat-1">
                      <!-- Painel a ser impresso -->
                       <c:forEach var="evento" items="${listaEventos}" varStatus="id">
                        <div class="panel panel-default panel-faq">
                            <div class="panel-heading">
                                <a data-toggle="collapse" data-parent="#accordion-cat-1" href="#faq-cat-${id.count}-sub-1">
                                    <h4 class="panel-title">
                                        ${evento.nome }
                                        <span class="pull-right"><i class="glyphicon glyphicon-plus"></i></span>
                                    </h4>
                                </a>
            
                            </div>
                            <div id="faq-cat-${id.count}-sub-1" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <div  id="Eventos" style="display: block;">
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
                                                <b>${evento.nome}</b>
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
                                                 <a href="exibirAlterarEvento"><button class="btn btn-warning "> <span class="glyphicon glyphicon-pencil"></span></button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
                                                 <a href=""><button class="btn btn-danger" data-toggle="modal" data-target="#confirm"> <span class="glyphicon glyphicon-remove"></span></button></a>
                                                <br><hr>
                                                		<div class="modal fade" id="confirm" role="dialog">
														  <div class="modal-dialog modal-md">
														
														    <div class="modal-content">
														      <div class="modal-body">
														            <p> Tem certeza que gostaria que excluir evento?</p>
														      </div>
														      <div class="modal-footer">
														        <a href="wfefwe" type="button" class="btn btn-danger" id="delete">Sim</a>
														            <button type="button" data-dismiss="modal" class="btn btn-default">Cancelar</button>
														      </div>
														    </div>
														
														  </div>
														</div>
                                                	
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
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <c:forEach var="atividade" items="${listaAtividades}">
                                                <c:if test="${evento.id == atividade.id_evento }">
                                                    <tr>
                                                        <td>${atividade.nome}</td>
                                                        <td><fmt:formatDate value="${atividade.data}" pattern="dd/MM/yyyy"/></td>
                                                        <td>${atividade.horaInicio}</td>
                                                        <td><a href=""><button class="btn btn-info">Gerar ata</button></a>
                                                        <td><a href="alterarAtv"><button class="btn btn-warning "> <span class="glyphicon glyphicon-pencil"></span></button></a>
                                                        <td><a href="removerAtividade"><button class="btn btn-danger"> <span class="glyphicon glyphicon-remove"></span></button></a>
                                                    </tr>
                                                </c:if>
                                             </c:forEach>
                                      </table>
                               </div>
                                </div>
                            </div>
                        </div>
                    </div>
                  </c:forEach>
                </div>
                </div>
               
          </div>
        </div>
    </div>
  </div>

                    <!-- Fim atividades -->

                </div>
            </div>
                   
<script type="text/javascript">
$(document).ready(function() {
    $('.collapse').on('show.bs.collapse', function() {
        var id = $(this).attr('id');
        $('a[href="#' + id + '"]').closest('.panel-heading').addClass('active-faq');
        $('a[href="#' + id + '"] .panel-title span').html('<i class="glyphicon glyphicon-minus"></i>');
    });
    $('.collapse').on('show.bs.collapse', function() {
        var id = $(this).attr('id');
        $('a[href="#' + id + '"]').closest('.panel-heading').removeClass('active-faq');
        $('a[href="#' + id + '"] .panel-title span').html('<i class="glyphicon glyphicon-plus"></i>');
    });
});
</script>
<c:import url="/view/linkjs.jsp" />
</body>
</html>

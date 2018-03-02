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
</head>

<body>
<c:import url="../comum/navbarUsuario.jsp" />

	<h1>A atividade escolhida é ${atvEscolhida.nome}</h1>
	<h2>Ocorrerá na data: <fmt:formatDate value="${atvEscolhida.data}" pattern="dd/MM/yyyy"/></h2>
	<h2>No horário: ${atvEscolhida.horaInicio}</h2>
	<h2>Ministrada por: ${atvEscolhida.orientador}</h2>
	<a href="participacaoConfirmada?id=${atvEscolhida.id}"><button>CONFIRMAR</button></a>
<c:import url="/view/linkjs.jsp" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
<title>Atualização de Receita</title>
<%@ include file="header.jsp" %>
</head>
<body>
<%@ include file="menu.jsp" %>
<div class="container">
	<h1>Edição de Receita</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<c:if test="${not empty erro }">
		<div class="alert alert-danger">${erro}</div>
	</c:if>
	<form action="receita" method="post">
		<input type="hidden" value="editar" name="acao">
		<input type="hidden" value="${receita.codigo}" name="codigo">
		<div class="form-group">
			<label for="id-nome">Nome</label>
			<input type="text" name="nome" id="id-nome" class="form-control" value="${receita.nome}" >
		</div>
		<div class="form-group">
			<label for="id-valor">Valor</label>
			<input type="text" name="valor" id="id-valor" class="form-control" value="${receita.valor}">
		</div>
		<div class="form-group">
			<label for="id-dataReceita">Data da Receita</label>
			<input type="text" name="dataReceita" id="id-dataReceita" class="form-control" 
				value='<fmt:formatDate value="${receita.dataReceita.time }" pattern="dd/MM/yyyy"/>'>
		</div>
		<input type="submit" value="Salvar" class="btn btn-primary">
		<a href="receita?acao=listar" class="btn btn-danger">Cancelar</a>
	</form>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
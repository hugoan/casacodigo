<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de Java, Android, iPhone, Ruby, PHP e muito mais -
	Casa do C�digo</title>

<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />

<style type="text/css">
        body{
           padding-bottom: 60px
        }
    </style>

</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Casa do C�digo</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="${s:mvcUrl('PC#listar').build()}">Lista de Produtos</a></li>
        <li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
        
      </ul>
      
      <ul>
      	 <li>
		    <a href="#">
		        <security:authentication property="principal" var="usuario"/>
		        Usu�rio: ${usuario.username}
		    </a>
		</li>
      </ul>

	</div><!-- /.navbar-collapse -->
  </div>
</nav>

<div class="container">
	<h1>Lista de Produtos</h1>
	<br>
	<div>${message}</div>
	<br>
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>T�tulo</th>
			<th>descri��o</th>
			<th>P�ginas</th>
		</tr>

		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td><a
					href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a></td>
				<td>${produto.descricao}</td>
				<td>${produto.paginas}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>			
		
<a href="/carrinho" rel="nofollow">Carrinho (${carrinhoCompras.quantidade})</a>
	
	<article id="${produto.id}" >
	<header id="product-highlight" class="clearfix">
		<div id="product-overview" class="container">
			<img width="280px" height="395px"
				src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145"
				class="product-featured-image" />
			<h1>${produto.titulo}</h1>
			<p>${produto.descricao}</p>
		</div>
	</header>


	<section class="buy-options clearfix">
		<form action="/casacodigo/carrinho/add" method="post" class="container">
			<ul>
				<input type="hidden" name="produtoId" value="${produto.id}" />
					<c:forEach items="${produto.precos}" var="preco">
						<li class="buy-option">
						<input type="radio" name="tipo" class="variant-radio" id="tipo" value="${preco.tipo}" checked="checked" /> 
							<label class="variant-label">${preco.tipo}</label> 
							<p class="variant-price">${preco.preco}</p></li>
					</c:forEach>
			</ul>
			<button type="submit" value="Compre Agora">Compre Agora</button>
		</form>

	</section>
	
</body>
</html>
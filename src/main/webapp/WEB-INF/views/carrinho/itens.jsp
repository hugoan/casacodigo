<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

	<ul class="clearfix">
		<li><a href="" rel="nofollow">Carrinho
				(${carrinhoCompras.quantidade})</a></li>
	</ul>


	<h2>Seu carrinho de compras</h2>


		<table>
			<tr>
					<th class="cart-img-col"></th>
					<th width="65%">Item</th>
					<th width="10%">Preço</th>
					<th width="10%">Quantidade</th>
					<th width="10%">Total</th>
					<th width="5%"></th>
			</tr>
			
			<c:forEach items="${carrinhoCompras.itens}" var="item">

			<tr>
					<td class="cart-img-col"><img
							src="http://cdn.shopify.com/s/files/1/0155/7645/products/css-eficiente-featured_large.png?v=1435245145"
							width="71px" height="100px" /></td>
					<td id="titulo">${item.produto.titulo}</td>
					<td id="preco">${item.preco}</td>
					<td id="quantidade">
						<input type="number" min="0" readonly="readonly" id="quantidade" name="quantidade" 
							value="${carrinhoCompras.getQuantidade(item) }" /></td>
					<td id="total">${carrinhoCompras.getTotal(item)}</td>
					<td>
						<form action="" method="post">
							<input type="submit" value="Excluir"/>
						</form>
					</td>
			</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3"><input type="submit" class="checkout"
						name="checkout" value="Finalizar compra" /></td>
					<td class="numeric-cell">${carrinhoCompras.total}</td>
					<td></td>
				</tr>
			</tfoot>
		</table>

		
</body>
</html>
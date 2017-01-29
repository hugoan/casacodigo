package br.com.casacodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.casacodigo.loja.dao.ProdutoDAO;
import br.com.casacodigo.loja.model.CarrinhoCompras;
import br.com.casacodigo.loja.model.CarrinhoItem;
import br.com.casacodigo.loja.model.Produto;
import br.com.casacodigo.loja.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

	@Autowired
	ProdutoDAO produtoDAO;
	
	@Autowired
	CarrinhoCompras carrinho;
	
	@RequestMapping("/add")
	public ModelAndView add(Long produtoId, TipoPreco tipo){
		ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
		CarrinhoItem carinhoItem = criaItem(produtoId, tipo);
		carrinho.add(carinhoItem);
		return modelAndView;
	}
	
	private CarrinhoItem criaItem(Long produtoId, TipoPreco tipo){
		Produto produto = produtoDAO.find(produtoId);
		CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
		return carrinhoItem;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
	    return new ModelAndView("carrinho/itens");
	}
}

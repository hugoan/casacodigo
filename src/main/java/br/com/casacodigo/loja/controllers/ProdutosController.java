package br.com.casacodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casacodigo.loja.dao.ProdutoDAO;
import br.com.casacodigo.loja.model.Produto;
import br.com.casacodigo.loja.model.TipoPreco;

@Controller
//@RequestMapping("produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDAO;

	@RequestMapping("/produtos/form")
	public ModelAndView form() {

		ModelAndView modelAndView = new ModelAndView("/produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());

		return modelAndView;
	}

	@RequestMapping("produtos")
	public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {
		System.out.println("Produto " + produto.getTitulo() + " gravado com sucesso!");
		produtoDAO.gravar(produto);

		redirectAttributes.addFlashAttribute("message", "O produto foi salvo com sucesso!");

		return new ModelAndView("redirect:produtos/lista");
	}

	@RequestMapping("/produtos/lista")
	public ModelAndView listar() {
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView modelAndView = new ModelAndView("/produtos/lista");
		modelAndView.addObject("produtos", produtos);

		return modelAndView;
	}
}

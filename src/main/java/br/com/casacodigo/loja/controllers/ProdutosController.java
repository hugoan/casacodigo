package br.com.casacodigo.loja.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos/form")
	public String form(){
		System.out.println("Estou acessando o controller");
		return "/produtos/form";
	}
}

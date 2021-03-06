package br.com.casacodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casacodigo.loja.dao.ProdutoDAO;
import br.com.casacodigo.loja.infra.FileSaver;
import br.com.casacodigo.loja.model.Produto;
import br.com.casacodigo.loja.model.TipoPreco;
import br.com.casacodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	public void InitBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidation());
	}

	@RequestMapping("/form")
	public ModelAndView form(Produto produto) {

		ModelAndView modelAndView = new ModelAndView("/produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());

		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="produtosHome", allEntries=true)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		
				
		if(result.hasErrors()){
			return form(produto);
		}
		
		String path = fileSaver.write("arquivos-sumario", sumario);
		produto.setSumarioPath(path);
		
		produtoDAO.gravar(produto);
		redirectAttributes.addFlashAttribute("message", "O produto foi salvo com sucesso!");

		return new ModelAndView("redirect:produtos");
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDAO.listar();
		ModelAndView modelAndView = new ModelAndView("/produtos/lista");
		modelAndView.addObject("produtos", produtos);

		return modelAndView;
	}
	
	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Long id){
	    ModelAndView modelAndView = new ModelAndView("/produtos/detalhe");
	    Produto produto = produtoDAO.find(id);
	    modelAndView.addObject("produto", produto);
	    return modelAndView;
	}
}

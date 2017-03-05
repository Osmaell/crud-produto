package br.com.osmael.crud.produto.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.osmael.crud.produto.entity.Produto;
import br.com.osmael.crud.produto.repository.Produtos;
	
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private Produtos produtos;
	
	@RequestMapping("/novo")
	public String novo(Model model) {
		model.addAttribute(new Produto());
		return "CadastroProduto";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView cadastrar(@Validated Produto produto, Errors errors) {
		
		ModelAndView mv = new ModelAndView("CadastroProduto");
		
		if (errors.hasErrors()) {
			return mv;
		}
		
		produtos.save(produto);
		mv.addObject("mensagem", "Produto cadastrado com sucesso!");
		
		return mv;
	}
	
	@RequestMapping
	public String pesquisar() {
		return "PesquisaProduto";
	}
	
}
package br.com.osmael.crud.produto.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.osmael.crud.produto.entity.Produto;
import br.com.osmael.crud.produto.repository.Produtos;
import br.com.osmael.crud.produto.service.FormatoDataInvalidoException;
import br.com.osmael.crud.produto.service.ProdutoService;
	
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	private static final String CADASTRO_VIEW = "CadastroProduto";
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute(new Produto());
		return CADASTRO_VIEW;
	}
	
	@PostMapping
	public String salvar(@Validated Produto produto, Errors errors, RedirectAttributes attributes) {
		
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		try {
			produtoService.salvar(produto);
			attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso!");
			return "redirect:/produtos/novo";
		} catch (FormatoDataInvalidoException e) {
			errors.rejectValue("dataVencimento", e.getMessage(), e.getMessage());
			return CADASTRO_VIEW;
		}
		
	}
	
	@GetMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Produto produto) {
		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(produto);
		
		return mv;
	}
	
	@GetMapping
	public ModelAndView pesquisar() {
		
		ModelAndView mv = new ModelAndView("PesquisaProduto");
		mv.addObject("produtos", produtos.findAll());
		
		return mv;
	}
	
	@DeleteMapping(value = "{codigo}")
	public String exclui(@PathVariable Long codigo, RedirectAttributes attributes) {
		this.produtoService.excluir(codigo);
		attributes.addFlashAttribute("mensagem", "Produto excluído com sucesso!");
		return "redirect:/produtos";
	}
	
}
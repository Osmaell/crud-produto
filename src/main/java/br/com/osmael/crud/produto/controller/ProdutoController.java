package br.com.osmael.crud.produto.controller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.osmael.crud.produto.entity.Produto;
import br.com.osmael.crud.produto.repository.Produtos;
	
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	private static final String CADASTRO_VIEW = "CadastroProduto";
	
	@Autowired
	private Produtos produtos;
	
	@RequestMapping("/novo")
	public String novo(Model model) {
		model.addAttribute(new Produto());
		return CADASTRO_VIEW;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Produto produto, Errors errors, RedirectAttributes attributes) {
		
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		try {
			produtos.save(produto);
			attributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
			return "redirect:/produtos/novo";
		} catch (DataIntegrityViolationException e) {
			errors.rejectValue("dataVencimento", null, "Formato de data inválido!");
			return CADASTRO_VIEW;
		}
		
	}
	
	@RequestMapping
	public String pesquisar() {
		return "PesquisaProduto";
	}
	
}
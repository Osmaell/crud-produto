package br.com.osmael.crud.produto.controller;
	
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
	
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroProduto";
	}
	
	@RequestMapping
	public String pesquisar() {
		return "PesquisaProduto";
	}
	
}
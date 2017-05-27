package br.com.osmael.crud.produto.service;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
	
import br.com.osmael.crud.produto.entity.Produto;
import br.com.osmael.crud.produto.repository.Produtos;
	
@Service
public class ProdutoService {
	
	@Autowired
	private Produtos produtos;
	
	public void salvar(Produto produto) {
		
		try {
			this.produtos.save(produto);
		} catch (DataIntegrityViolationException e) {
			throw new FormatoDataInvalidoException("Formato de data inválido");
		}
		
	}
	
	public void excluir(Long codigo) {
		this.produtos.delete(codigo);
	}
	
}
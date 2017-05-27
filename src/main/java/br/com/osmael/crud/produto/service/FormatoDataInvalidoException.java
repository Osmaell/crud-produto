package br.com.osmael.crud.produto.service;

public class FormatoDataInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public FormatoDataInvalidoException(String message) {
		super(message);
	}
	
}
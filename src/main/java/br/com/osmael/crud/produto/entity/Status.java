package br.com.osmael.crud.produto.entity;

public enum Status {

	VENCIDO("Vencido"),
	VALIDO("Válido");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
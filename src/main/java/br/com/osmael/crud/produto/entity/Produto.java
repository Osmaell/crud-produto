package br.com.osmael.crud.produto.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O código é obrigatório")
	@Column(unique = true)
	private String codigo;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 60, message = "O nome não pode conter mais de 60 caracteres")
	private String nome;
	
	@NotBlank(message = "Categoria é obrigatória")
	@Size(max = 60, message = "A categoria não pode conter mais de 60 caracteres")
	private String categoria;
	
	@NotNull(message = "Preço é obrigatório")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999", message = "Valor não pode ser 9.999.999")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal preco;
	
	@NotNull(message = "Quantidade é obrigatória")
	@DecimalMin(value = "0", message = "Quantidade não pode ser menor que 0")
	@DecimalMax(value = "9999999", message = "Quantidade não pode ser maior que 9.999.999")
	@NumberFormat(pattern = "#,##0.00")
	private Integer quantidade;
	
	@NotNull(message = "Data de vencimento é obrigatória")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento")
	private Date dataVencimento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public boolean isVencido() {
		
		int verifica = Calendar.getInstance().getTime().compareTo(dataVencimento);
		
		if (verifica == 1) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
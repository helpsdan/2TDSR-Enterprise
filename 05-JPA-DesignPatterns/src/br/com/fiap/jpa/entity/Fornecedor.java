package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_FORNECEDOR")
public class Fornecedor {

	@Id
	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Column(name="nm_fornecedor")
	private String nome;
	
	public Fornecedor() {
	 
	}
	
	public Fornecedor(String cnpj, String nome) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
}

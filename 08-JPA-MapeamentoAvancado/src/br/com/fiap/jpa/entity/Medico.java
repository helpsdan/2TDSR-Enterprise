package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SecondaryTable(name="T_MEDICO_FINANCEIRO")
public class Medico {

	@Id
	@Column(name="nr_crm")
	private int crm;
	
	@Column(name="vl_salario", table="T_MEDICO_FINANCEIRO")
	private float salario;

	@Column(name="nr_conta", table="T_MEDICO_FINANCEIRO")
	private int conta;
	
	@Column(name="nm_medico",length=100)
	private String nome;
	
	public Medico() {
		super();
	}

	public Medico(int crm, float salario, int conta, String nome) {
		super();
		this.crm = crm;
		this.salario = salario;
		this.conta = conta;
		this.nome = nome;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

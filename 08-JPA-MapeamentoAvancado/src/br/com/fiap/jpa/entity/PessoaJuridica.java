package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// CONFIGURAÇÕES PARA SINGLE JOIN
@DiscriminatorColumn(name="DS_TIPO)
@DiscriminatorValue("PJ")
@Entity
@Table(name="T_PESSOA_JURIDICA)
public class PessoaJuridica extends Pessoa{

	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_fundacao")
	private Calendar dataFundacao;

	public PessoaJuridica() {
	
	}
	
	public PessoaJuridica(String nome, String endereco, String cnpj, Calendar dataFundacao) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	
	
}

package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PAGAMENTO")
@SequenceGenerator(name="pagamento", sequenceName="SQ_T_PAGAMENTO", allocationSize=1)
public class Pagamento {

	@Id
	@Column(name="cd_pagamento")
	@GeneratedValue(generator="pagamento", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_pagamento", nullable=false)
	private Calendar dataPagamento;
	
	@Column(name="vl_pagamento", nullable=false)
	private float valor;
	
	@Enumerated
	@Column(name="ds_forma_pagamento", nullable=false)
	private FormaPagamento formaPagamento;
	
	@OneToOne
	@JoinColumn(name="cd_corrida")
	private Corrida corrida;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Pagamento(Calendar dataPagamento, float valor, FormaPagamento formaPagamento) {
		super();
		this.dataPagamento = dataPagamento;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public Pagamento() {
		super();
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

	
	
	
	
}

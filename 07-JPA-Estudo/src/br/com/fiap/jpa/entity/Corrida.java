package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName="SQ_T_CORRIDA", allocationSize=1)
public class Corrida {

	@Id
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_corrida")
	private int codigo;
	
	@Column(name="ds_origem",length=150)
	private String origem;
	
	@Column(name="ds_destino",length=150)
	private String destino;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_corrida")	
	private Calendar dataCorrida;
	
	@ManyToOne
	@JoinColumn(name="cd_passageiro")
	private Passageiro passageiro;	
	
	@ManyToOne
	@JoinColumn(name="cd_motorista")
	private Motorista motorista;
	
	@OneToOne(mappedBy="corrida")
	private FormaPagamento formaPagamento;
	
	@Column(name="vl_corrida", nullable=false)
	private float valor;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getDataCorrida() {
		return dataCorrida;
	}

	public void setDataCorrida(Calendar dataCorrida) {
		this.dataCorrida = dataCorrida;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Corrida(String origem, String destino, Calendar dataCorrida, float valor) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.dataCorrida = dataCorrida;
		this.valor = valor;
	}
	
	public Corrida() {
		// TODO Auto-generated constructor stub
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
}

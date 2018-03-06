package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name = "nr_carteira", nullable = false)
	private int numeroCarteira;

	@Column(name = "nm_motorista", nullable = false, length = 150)
	private String nome;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Calendar dataNascimento;

	@Lob
	@Column(name = "fl_carteira")
	private byte[] carteira;

	@Column(name = "ds_genero")
	private Sexo sexo;

	public Motorista(int numeroCarteira, String nome, Calendar dataNascimento, byte[] carteira, Sexo sexo) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.dataNascimento = dataNascimento;
		this.carteira = carteira;
		this.sexo = sexo;
	}

	public Motorista() {
		// TODO Auto-generated constructor stub
	}

	public int getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(int numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getCarteira() {
		return carteira;
	}

	public void setCarteira(byte[] carteira) {
		this.carteira = carteira;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}

package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name="nr_carteira")
	private int numeroCarteira;
	
	@Column(name="nm_motorista",length=150, nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] carteira;
	
	@Enumerated
	@Column(name="ds_genero")
	private Genero genero;
	
	@OneToMany(mappedBy="motorista")
	private Corrida corrida;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinTable(name="T_VEICULO_MOTORISTA",
				joinColumns={@JoinColumn(name="cd_motorista")}, 
				inverseJoinColumns= {@JoinColumn(name="cd_veiculo")})
	private Veiculo veiculo;
	
	public int getCodigo() {
		return numeroCarteira;
	}

	public void setCodigo(int codigo) {
		this.numeroCarteira = codigo;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Motorista(String nome, Calendar dataNascimento, byte[] carteira, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.carteira = carteira;
		this.genero = genero;
	}
	
	public Motorista() {
		// TODO Auto-generated constructor stub
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	
}

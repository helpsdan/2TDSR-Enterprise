package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PASSAGEIRO")
@SequenceGenerator(name="passageiro", sequenceName="SQ_T_PASSAGEIRO", allocationSize=1)
public class Passageiro {

	@Id
	@Column(name="cd_passageiro")
	@GeneratedValue(generator="passageiro", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_passageiro", length=100, nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Enumerated
	@Column(name="ds_genero")
	private Genero genero;
	
	@OneToMany(mappedBy="passageiro")
	private Corrida corrida;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Passageiro() {
		super();
	}

	public Passageiro(String nome, Calendar dataNascimento, Genero genero) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}
	
	
	
	
}

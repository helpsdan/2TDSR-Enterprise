package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CONSULTA")
@IdClass(ConsultaPK.class)
public class Consulta {

	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="nr_crm")
	private Medico medico;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_paciente")
	private Paciente paciente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_consulta")
	private Calendar dataConsulta;
	
	@Column(name="st_convenio")
	private boolean convenio;
	
	@Column(name="ds_consultorio")
	private String consultorio;

	public Consulta() {
		super();
	}
	
	public Consulta(Medico medico, Paciente paciente, Calendar dataConsulta, boolean convenio, String consultorio) {
		this.medico = medico;
		this.paciente = paciente;
		this.dataConsulta = dataConsulta;
		this.convenio = convenio;
		this.consultorio = consultorio;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Calendar getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Calendar dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}
	
			
	
	
}


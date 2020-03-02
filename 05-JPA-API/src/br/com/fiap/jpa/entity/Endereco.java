package br.com.fiap.jpa.entity;


import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "TB_ENDERECO")
@SequenceGenerator(name="endereco", sequenceName ="SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {

	
	@Id
	@Column(name="CD_ENDERECO" , nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
	private int id;
	
	@Column(name="NR_CEP", nullable = false,length = 8)
	private String cep;
	
	@Column(name = "DS_LOGRADOURO", nullable = false, length = 50)
	private String Logradouro;
	
	@Column(name = "DS_TIPO")
	@Enumerated(EnumType.STRING)
	private TipoLogr tipo;
	
	@CreationTimestamp //-- CRIA A DATA DE CADASTRO AUTOMATICAMNETE
	@Column(name = "DT_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;

	public Endereco(String cep, String logradouro, TipoLogr tipo) {
		super();
		this.cep = cep;
		Logradouro = logradouro;
		this.tipo = tipo;
	}

	public Endereco() {
		super();
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public TipoLogr getTipo() {
		return tipo;
	}

	public void setTipo(TipoLogr tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	
	
}
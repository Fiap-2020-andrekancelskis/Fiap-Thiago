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

@Entity
@Table(name = "TB_COLABORADOR")
@SequenceGenerator(name = "funcionario", allocationSize = 1, sequenceName = "SQ_TB_FUNCIONARIO")
public class Colaborador {

	@Id
	@Column(name = "cd_coloborador", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
	private int codigo;
	
	@Column(name = "nm_colaborador", nullable = false, length = 100)
	private String nome;

	@Column(name = "ds_cargo")
	@Enumerated(EnumType.STRING)
	private TipoCola tipo;
	
	@Column(name = "dt_admissao")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dt_admissao;
	
	@Column(name = "vl_salario")
	private float salario;

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

	public TipoCola getTipo() {
		return tipo;
	}

	public void setTipo(TipoCola tipo) {
		this.tipo = tipo;
	}

	public Calendar getDt_admissao() {
		return dt_admissao;
	}

	public void setDt_admissao(Calendar dt_admissao) {
		this.dt_admissao = dt_admissao;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Colaborador(String nome, TipoCola tipo, Calendar dt_admissao, float salario) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.dt_admissao = dt_admissao;
		this.salario = salario;
	}

	public Colaborador() {
		super();
	}
	
	
}

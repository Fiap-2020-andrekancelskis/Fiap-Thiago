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
@Table(name = "TB_CONTA")
@SequenceGenerator(name = "conta", allocationSize = 1, sequenceName = "SQ_TB_CONTA")
public class Conta {

	@Id
	@Column(name = "cd_codigo", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conta")
	private int codigo;
	
	@Column(name = "nr_agencia", nullable = false)
	private int agencia;
	
	@Column(name = "ds_tipo")
	@Enumerated(EnumType.STRING)
	private TipoConta tipo;
	
	@Column(name = "vl_saldo")
	private float saldo;
	
	@Column(name = "dt_abertura")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dtAbertura;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Calendar getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Calendar dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Conta(int agencia, TipoConta tipo, float saldo, Calendar dtAbertura) {
		super();
		this.agencia = agencia;
		this.tipo = tipo;
		this.saldo = saldo;
		this.dtAbertura = dtAbertura;
	}

	public Conta() {
		super();
	}
	
	
}

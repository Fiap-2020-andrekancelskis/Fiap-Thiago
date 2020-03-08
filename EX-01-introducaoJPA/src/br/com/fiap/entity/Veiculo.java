package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_VEICULO")
@SequenceGenerator(name ="veiculo", allocationSize = 1, sequenceName = "SQ_T_VEICULO")
public class Veiculo {
	
	@Id
	@Column(name = "CD_VEICULO", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
	private int codigo;
	
	@Column(name = "DS_PLACA", nullable = false , length = 9)
	private String placa;
	
	@Column(name = "DS_COR", nullable = false, length = 20)
	private String cor;
	
	@Column(name = "NR_ANO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar ano;

	
	public Veiculo(int codigo, String placa, String cor, Calendar ano) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}
	public Veiculo(String placa, String cor, Calendar ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public Veiculo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Calendar getAno() {
		return ano;
	}

	public void setAno(Calendar ano) {
		this.ano = ano;
	}

	
	
	
	
	
	

}

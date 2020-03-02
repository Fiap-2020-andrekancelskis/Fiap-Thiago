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
	public int veiculo;
	
	@Column(name = "DS_PLACA", nullable = false , length = 9)
	public String placa;
	
	@Column(name = "DS_COR", nullable = false, length = 20)
	public String cor;
	
	@Column(name = "NR_ANO")
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar ano;

	public int getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(int veiculo) {
		this.veiculo = veiculo;
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

	public Veiculo(int veiculo, String placa, String cor, Calendar ano) {
		super();
		this.veiculo = veiculo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public Veiculo() {
		super();
	}
	
	
	
	
	
	

}

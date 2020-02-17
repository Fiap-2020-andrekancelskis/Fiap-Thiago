package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="TB_CLIENTE")
@SequenceGenerator(name ="cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {
	
	@Id
	@Column(name="CD_CLIENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private int codigo;
	
	@Column(name="NM_CLIENTE", nullable = false, length = 100)
	private String nome;
	
	@Column(name="DS_CPF", length = 11)
	private String cpf;
	
	@Column(name="DT_NASCIMENTO", nullable = false )
	@Temporal(TemporalType.DATE)
	private Calendar dt_nasc;
	
	@Column(name="DS_EMAIL", nullable = false, length = 155)
	private String email;
	
	@Column(name="DS_TIPO", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCliente tipo;
	
	@Lob	 
	@Column(name="IMG_CLIENTE")
	private byte [] foto;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Calendar dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
	
	
}

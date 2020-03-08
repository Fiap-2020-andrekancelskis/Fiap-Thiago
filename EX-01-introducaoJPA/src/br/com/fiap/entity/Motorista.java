package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MOTORISTA")
public class Motorista {

	
	@Id
	@Column(name = "nr_carteira", nullable = false)
	private int Numcarteira;
	
	@Column(name = "nm_motorista", nullable = false, length = 150)
	private String nomeMotorista;
	
	@Column(name = "dt_nascimento")
	private Calendar dt_nasc;
	
	@Column(name = "fl_carteira")
	private byte[] carteira;
	
	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING)
	private Tp_genero genero;
	

	public int getNumcarteira() {
		return Numcarteira;
	}

	public void setNumcarteira(int numcarteira) {
		Numcarteira = numcarteira;
	}

	public String getNomeMotorista() {
		return nomeMotorista;
	}

	public void setNomeMotorista(String nomeMotorista) {
		this.nomeMotorista = nomeMotorista;
	}

	public Calendar getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(Calendar dt_nasc) {
		this.dt_nasc = dt_nasc;
	}

	public byte[] getCarteira() {
		return carteira;
	}

	public void setCarteira(byte[] carteira) {
		this.carteira = carteira;
	}

	public Tp_genero getGenero() {
		return genero;
	}

	public void setGenero(Tp_genero genero) {
		this.genero = genero;
	}

	public Motorista(int numcarteira, String nomeMotorista, Calendar dt_nasc, byte[] carteira, Tp_genero genero) {
		super();
		Numcarteira = numcarteira;
		this.nomeMotorista = nomeMotorista;
		this.dt_nasc = dt_nasc;
		this.carteira = carteira;
		this.genero = genero;
	}

	public Motorista() {
		super();
	}
	
	
 }

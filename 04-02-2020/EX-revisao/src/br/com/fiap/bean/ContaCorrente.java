package br.com.fiap.bean;

import java.util.Calendar;

public class ContaCorrente extends Conta {

	private TipoConta tipo;
	private double saldoRetirar;

	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo) {
		super(agencia, numero, dataAbertura, saldo);
	}

	public double depositar(double valor) {
		return saldo += valor;
	}

	public double retirar(double valor) {
		saldoRetirar = saldo - valor;
		if (tipo.equals(TipoConta.Comum) && saldo < saldoRetirar) {
			Exception e = new Exception();
			e.printStackTrace();
		}
		return saldoRetirar;
	}
}

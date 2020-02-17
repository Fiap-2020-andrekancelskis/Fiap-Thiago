package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.bean.Conta;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class TesteContaCorrente {

	public static void main(String[] args) {

		ContaCorrente cc = new ContaCorrente(1, 12, Calendar.getInstance(), 100, TipoConta.COMUM);
		
		ContaPoupanca cp = new ContaPoupanca(1, 123, new GregorianCalendar(2019, Calendar.MAY, 20), 1500, 2);
		
		//criar uma lista e adicionar 3 contas
		List<Conta> lista = new ArrayList<Conta>();
		
		lista.add(cc);
		lista.add(cp);
		lista.add(new ContaCorrente(1, 32, Calendar.getInstance(), 500, TipoConta.ESPECIAL));
		
		
		//exibir saldo dsa contas
		for (Conta conta: lista) {
			System.out.println("Saldo: "+conta.getSaldo());
			System.out.println("======");
		}
		
		//testar metodo retirar da conta corrente
		try {
			cc.retirar(500);
		}catch (SaldoInsuficienteException e1) { //açao  para tratar essa excpetion especifica de saldo-insuficiente
			System.err.println(e1.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());//recupera a mensagem da execução quando foi instaciada
		}
		
		
		}
}

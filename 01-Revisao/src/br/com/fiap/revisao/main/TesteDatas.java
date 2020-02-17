package br.com.fiap.revisao.main;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteDatas {

	public static void main(String[] args) {

		// Obter um objeto com a data atual
		Calendar hoje = Calendar.getInstance();
		// obter uma data especfica
		Calendar caraval = new GregorianCalendar(2020, Calendar.FEBRUARY, 22);

		// Exibir na tela
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(formatador.format(hoje.getTime()));
		System.out.println(formatador.format(caraval.getTime()));
		
		LocalDate hora = LocalDate.now();
		
		
		DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		hora.format(formatador2);
		
		System.out.println(formatador2.format(hora));
	}

}

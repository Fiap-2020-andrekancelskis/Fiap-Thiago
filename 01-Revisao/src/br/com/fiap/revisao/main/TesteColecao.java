package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.bean.Computador;

public class TesteColecao {

	public static void main(String[] args) {
		
		//criar lista 
		List<Computador> computadores = new ArrayList<Computador>();
		//cerregar lista
		for (int i = 1; i < 10; i++) {
			Computador c = new Computador("i" + i, i*100);
			computadores.add(c);

		}
		// imprimir lista
		for (Computador churros : computadores) {
			System.out.println(churros.getNome()+ " " + churros.getPreco());
			
		}
		
		Map<String, Computador> mapa = new HashMap<String, Computador>();
		mapa.put("dell", new Computador("dell i3", 1000));
		mapa.put("hp", new Computador("HP i7", 2000));
		
		Computador c = mapa.get("dell");
		System.out.println(c.getNome() + " "+ c.getPreco());
		
	}
}

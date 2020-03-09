package br.com.fiap.jpa.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * classe que gerencia a fabrica de entity menager /*permitindo somente uma
 * unica instancia da fabrica
 */

public class EntityManagerFactorySingleton {

	// atributo estatico que armazena a unica instancia
	private static EntityManagerFactory fabrica;
	
	//construtor privado  -> não é possivel instanciar a classe
	private EntityManagerFactorySingleton() {}

	// metodo estatico que retorna a unica instancia
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {// vericar para nao criar toda hora
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;

	}

}

package br.com.fiap.jpa.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.dao.impl.GenericDAOImpl;
import br.com.fiap.jpa.entity.Colaborador;
import br.com.fiap.jpa.entity.TipoCola;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View2 {

	public static void main(String[] args) {
		// obter uma intancia da fabrica
		// instanciar o entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

		// intanciar o entity manager
		EntityManager em = fabrica.createEntityManager();

		// instanciar o DAO generico sem preciso criar a classe e interface
		//instanciando uma classe anonima, filha do generic dao
		GenericDAO<Colaborador, Integer> dao = new GenericDAOImpl<Colaborador, Integer>(em) {}; // ABRIR {} classe anonima
				
		// cadastrar colaborador
		try {
			Colaborador c = new Colaborador("André Kancelskis", TipoCola.SENIOR, Calendar.getInstance(), 2000);
			dao.cadastrar(c);
			dao.commit();
			System.out.println("\nCADASTRADO\n");
		} catch (CommitException e) {
			System.out.println("\nERRO\n");
			e.printStackTrace();
		}
		// fechar as paradas
		em.close();
		fabrica.close();
	}

}

package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ContaDAO;
import br.com.fiap.jpa.dao.impl.ContaDAOImpl;
import br.com.fiap.jpa.entity.Conta;
import br.com.fiap.jpa.entity.TipoConta;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//obter uma intancia da fabrica
		EntityManagerFactory fabrica = 
				EntityManagerFactorySingleton.getInstance();
		
		//intanciar o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//instanciar o DAO
		ContaDAO dao = new ContaDAOImpl(em);
	
		//cadastrar conta
		Conta conta = new Conta(15, TipoConta.CORRENTE, 1500, null);
		
		
		try {
			dao.cadastrar(conta);
			dao.commit();
			System.out.println("\nCADASTRADO\n");
		} catch (CommitException e) {
			System.out.println("\nERRO\n");
			e.printStackTrace();
		}
		//fechar as paradas
		em.close();
		fabrica.close();
	}
	
	
}

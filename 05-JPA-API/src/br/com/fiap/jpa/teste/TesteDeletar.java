package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.DAO.EnderecoDAOImpl;
import br.com.fiap.jpa.exception.EnderecoNaoExistenteException;

public class TesteDeletar {

	public static void main(String[] args) throws EnderecoNaoExistenteException {

		EntityManagerFactory ef = Persistence.createEntityManagerFactory("oracle");

		EntityManager em = ef.createEntityManager();

		EnderecoDAOImpl eDAO = new EnderecoDAOImpl(em);
		

			eDAO.deletar(2);
		
	}
}

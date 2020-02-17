package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TesteRefresh {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		Produto prod = em.find(Produto.class, 1);
		
		System.out.println(prod.getNome());
		
		prod.setNome("Samsung S10");
		
		System.out.println(prod.getNome());
		
		em.refresh(prod);
		
		System.out.println(prod.getNome());
		
		em.close();
		fabrica.close();

	}

}

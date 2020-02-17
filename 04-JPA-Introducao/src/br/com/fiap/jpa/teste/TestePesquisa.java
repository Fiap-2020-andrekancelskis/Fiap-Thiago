package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Produto;

public class TestePesquisa {

	public static void main(String[] args) {

		// pesquisar o produto 1
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		Produto prod = em.find(Produto.class, 2);

		System.out.println(prod.getNome());
		System.out.println(prod.getValorLiquido());

		// alterar o valor do produto
		prod.setValor(1500);

		em.getTransaction().begin();// começa a transação
		em.getTransaction().commit();

		em.close();
		fabrica.close();

	}

}

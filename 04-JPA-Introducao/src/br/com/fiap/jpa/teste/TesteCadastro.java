package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Categoria;
import br.com.fiap.jpa.entity.Produto;

public class TesteCadastro {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//instanciar o produto
		Produto prod = new Produto("Xiaomi", 1000, 950, null, null, Categoria.ELETRONICOS);
	
		
		em.persist(prod);//cadastro o produto 
		
		em.getTransaction().begin();//começa uma transação
		em.getTransaction().commit();// commit no banco
		
		em.close();
		fabrica.close();
		
	}

}

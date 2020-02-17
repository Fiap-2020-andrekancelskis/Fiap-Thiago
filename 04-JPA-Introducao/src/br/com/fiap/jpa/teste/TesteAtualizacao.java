package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Categoria;
import br.com.fiap.jpa.entity.Produto;

public class TesteAtualizacao {

	public static void main(String[] args) {
		//criar o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//instanciar um produto com id que existe no banco
		Produto prod = new Produto("Armario", 3600, 900, null, null, Categoria.MOVEIS);
		prod.setCodigo(1);
		//realizar o merge(passar o produto para o entity manager gerenciar)
		em.merge(prod);
		
		//commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		//fechar conexao
		em.close();
		fabrica.close();
		
		
	}

}

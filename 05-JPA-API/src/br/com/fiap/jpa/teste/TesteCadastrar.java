package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.DAO.EnderecoDAOImpl;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.TipoLogr;

public class TesteCadastrar {

	public static void main(String[] args) {

		Endereco e = new Endereco();
		
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = ef.createEntityManager();
		
		e.setCep("12345678");
		e.setLogradouro("afonso braz");
		e.setTipo(TipoLogr.RUA);
		e.setData(null);
		
		EnderecoDAOImpl eDAO =  new EnderecoDAOImpl(em);
		
		eDAO.cadastrar(e);
		
	}

}

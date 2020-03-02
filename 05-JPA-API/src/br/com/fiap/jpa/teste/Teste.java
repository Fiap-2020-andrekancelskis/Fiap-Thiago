package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.DAO.EnderecoDAOImpl;
import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.entity.TipoLogr;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EnderecoNaoExistenteException;

public class Teste {

	public static void main(String[] args) {

		// criar a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		// criar o entity manager
		EntityManager em = fabrica.createEntityManager();

		// criar o DAO
		EnderecoDAOImpl dao = new EnderecoDAOImpl(em);

		// cadastrar um endereco
		Endereco end = new Endereco("04511011", "Rua Alberto", TipoLogr.RUA);
		// e.setCep("12345678");
		// e.setLogradouro("afonso braz");
		// e.setTipo(TipoLogr.RUA);
		// e.setData(null);

		// fechar
		try {
			dao.cadastrar(end);
			dao.commit();
			System.out.println("\n======Cadastrado======\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
		//pesquisar o endereco cadastrado
		try {
			Endereco busca =dao.pesquisar(end.getId());
			System.out.println(busca.getLogradouro());
		}catch (EnderecoNaoExistenteException e) {
			e.printStackTrace();
		}
		
		//atualizar o enderço
		
		try {
			end.setLogradouro("Av Paulista");
			dao.atualizar(end);
			dao.commit();
			System.out.println("\n======Atualizado=======\n");
		} catch (EnderecoNaoExistenteException | CommitException e) {
			e.printStackTrace();
		}
		
		//Remover o endereço
		try {
			dao.deletar(end.getId());
			dao.commit();
			System.out.println("\n======Deletado======\n");
		} catch (EnderecoNaoExistenteException e) {
			e.printStackTrace();
		}catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();

	}
}

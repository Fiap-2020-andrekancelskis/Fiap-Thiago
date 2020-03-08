package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.DAO.MotoristaDAO;
import br.com.fiap.DAO.MotoristaDAOImpl;
import br.com.fiap.entity.Motorista;
import br.com.fiap.entity.Tp_genero;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.MotoristaNaoExistenteException;

public class TesteMotorista {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		EntityManager em = fabrica.createEntityManager();

		MotoristaDAOImpl dao = new MotoristaDAOImpl(em);

		// cadastrar

		Motorista mot = new Motorista(123, "Andre Oliveira", null, null, Tp_genero.MASCULINO);

		try {
			dao.cadastrar(mot);
			dao.commit();
			System.out.println("\n===CADASTRADO===\n");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		// pesquisar

		try {
			Motorista busca = dao.pesquisar(mot.getNumcarteira());
			System.out.println(busca.getNomeMotorista());
		} catch (MotoristaNaoExistenteException e) {
			e.printStackTrace();
		}

		// atualizar
		try {
			mot.setNomeMotorista("André Kancelskis");
			dao.atualizar(mot);
			dao.commit();
		} catch (MotoristaNaoExistenteException e) {
			e.printStackTrace();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//deletar
			
			try {
				dao.deletar(mot.getNumcarteira());
				dao.commit();
				System.out.println("\n ==DELETADO== \n");
			} catch (MotoristaNaoExistenteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CommitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		// fechar
		em.close();
		fabrica.close();

	}

}

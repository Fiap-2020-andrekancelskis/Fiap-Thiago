package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.DAO.VeiculoDAOImpl;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.VeiculooNaoExistenteException;

public class Teste {

	public static void main(String[] args) {

		// cria a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");

		// cria o entity manager
		EntityManager em = fabrica.createEntityManager();

		// cria o DAO
		VeiculoDAOImpl dao = new VeiculoDAOImpl(em);

		// cadastrar um veiculo======
		Veiculo veic = new Veiculo("DRH-4848", "prata", null);

		try {
			dao.cadastrar(veic);
			dao.commit();
			System.out.println("\n===CADASTRADO===\n");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// pesquisar veiculo=======

		try {
			Veiculo busca = dao.pesquisar(veic.getCodigo());
			System.out.println(busca.getPlaca());
		} catch (VeiculooNaoExistenteException e) {
			e.printStackTrace();
		}

		// atualizar veiculo==========
		try {
			veic.setPlaca("EAO-2929");
			dao.Atualizar(veic);
			dao.commit();
		} catch (CommitException | VeiculooNaoExistenteException e) {
			e.printStackTrace();
		}
		
		//deletar========
			try {
				dao.deletar(veic.getCodigo());
				dao.commit();
				System.out.println("\n ==DELETADO== \n");
			} catch (VeiculooNaoExistenteException e) {
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

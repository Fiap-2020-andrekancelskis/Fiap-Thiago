package br.com.fiap.DAO;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Motorista;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.MotoristaNaoExistenteException;

public class MotoristaDAOImpl implements MotoristaDAO{

	public EntityManager em;
	
	public MotoristaDAOImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void cadastrar(Motorista mot) {
		em.persist(mot);
	}

	@Override
	public Motorista pesquisar(int Numcarteira) throws MotoristaNaoExistenteException {
		Motorista mot = em.find(Motorista.class, Numcarteira);
		if(mot==null) {
			throw new MotoristaNaoExistenteException();
		}
		return mot;
	}

	@Override
	public void atualizar(Motorista mot) throws MotoristaNaoExistenteException {
		pesquisar(mot.getNumcarteira());
		em.merge(mot);
	}

	@Override
	public void deletar(int Numcarteira) throws MotoristaNaoExistenteException {
		Motorista mot = pesquisar(Numcarteira);
		em.remove(mot);
	}

	@Override
	public void commit() throws CommitException{
		try {
		em.getTransaction().begin();
		em.getTransaction().commit();
		}catch (Exception e) {
			em.getTransaction().rollback();
		}
		
		
	}

}

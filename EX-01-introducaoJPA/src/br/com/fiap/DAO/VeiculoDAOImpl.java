package br.com.fiap.DAO;

import javax.persistence.EntityManager;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.VeiculooNaoExistenteException;

public class VeiculoDAOImpl implements VeiculoDAO {

	private EntityManager em;

	public VeiculoDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void cadastrar(Veiculo veic) {
		em.persist(veic);

	}

	@Override
	public Veiculo pesquisar(int codigo) throws VeiculooNaoExistenteException {
		Veiculo veic = em.find(Veiculo.class, codigo);
		if (veic == null) {
			throw new VeiculooNaoExistenteException();
		}
		return veic;

	}

	@Override
	public void Atualizar(Veiculo veic) throws VeiculooNaoExistenteException {
		pesquisar(veic.getCodigo());
		em.merge(veic);

	}

	@Override
	public void deletar(int codigo) throws VeiculooNaoExistenteException {
		Veiculo veic = pesquisar(codigo);
		em.remove(veic);

	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();

		}
	}
}

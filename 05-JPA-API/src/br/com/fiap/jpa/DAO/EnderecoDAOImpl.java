package br.com.fiap.jpa.DAO;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EnderecoNaoExistenteException;


public class EnderecoDAOImpl implements EnderecoDAO{
	
	private EntityManager em;
	
	//cosntrutor que recebe o entityManager
	public EnderecoDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void cadastrar(Endereco end) {
		em.persist(end);
	}

	@Override
	public Endereco pesquisar(int codigo) throws EnderecoNaoExistenteException{
		Endereco end = em.find(Endereco.class, codigo);
		//valida se existe um endereco para ser removido/pesquisado
		if (end == null) {
			throw new EnderecoNaoExistenteException(); 
		}
		return end;
	}

	@Override
	public void atualizar(Endereco end) throws EnderecoNaoExistenteException{
		pesquisar(end.getId()); //valida se existe o endereco no banco para atualizar
		em.merge(end);
	}
	
	@Override
	public void deletar(int codigo) throws EnderecoNaoExistenteException {
		Endereco end = pesquisar(codigo);
		em.remove(end);
		//em.remove(pesquisar(codigo)); outra maneira sem instanciar o endereco nas linhas acima usando a pesquisa
	}
	
	@Override
	public void commit() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback(); //rollback desfaz a operação
			throw new CommitException(e.getMessage());
		}
		
	}
}

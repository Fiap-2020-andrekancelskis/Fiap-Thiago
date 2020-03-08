package br.com.fiap.DAO;

import br.com.fiap.entity.Motorista;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.MotoristaNaoExistenteException;

public interface MotoristaDAO {

	void cadastrar (Motorista mot);
	
	Motorista pesquisar(int Numcarteira) throws MotoristaNaoExistenteException;
	
	void atualizar(Motorista mot) throws MotoristaNaoExistenteException;
	
	void deletar(int Numcarteira) throws MotoristaNaoExistenteException;
	
	void commit() throws CommitException;
	
}

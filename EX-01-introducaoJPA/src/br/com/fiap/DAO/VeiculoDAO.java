package br.com.fiap.DAO;

import br.com.fiap.entity.Veiculo;
import br.com.fiap.execao.CommitException;
import br.com.fiap.execao.VeiculooNaoExistenteException;

public interface VeiculoDAO {
	
	void cadastrar(Veiculo veic);
	
	Veiculo pesquisar(int codigo) throws VeiculooNaoExistenteException;
	
	void Atualizar(Veiculo veic) throws VeiculooNaoExistenteException;
	
	void deletar(int codigo) throws VeiculooNaoExistenteException;
	
	void commit() throws CommitException;
	
	

}

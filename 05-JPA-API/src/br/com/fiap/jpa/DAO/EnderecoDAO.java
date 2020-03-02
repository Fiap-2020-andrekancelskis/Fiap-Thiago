package br.com.fiap.jpa.DAO;

import br.com.fiap.jpa.entity.Endereco;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.EnderecoNaoExistenteException;

public interface EnderecoDAO {

	void cadastrar(Endereco end);
	
	Endereco pesquisar(int codigo) throws EnderecoNaoExistenteException;
	
	void atualizar(Endereco end) throws EnderecoNaoExistenteException;
	
	void deletar(int codigo) throws EnderecoNaoExistenteException ;
	
	void commit() throws CommitException;
	
}

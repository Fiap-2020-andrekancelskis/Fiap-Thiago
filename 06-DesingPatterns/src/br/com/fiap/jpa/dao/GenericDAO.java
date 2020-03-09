package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFooundException;

public interface GenericDAO<T, K> {

	void cadastrar(T entity);

	void atulizar(T entity);

	T pesquisar(K id) throws KeyNotFooundException;;

	void deletar(K id) throws KeyNotFooundException;

	// commit
	void commit() throws CommitException;

}

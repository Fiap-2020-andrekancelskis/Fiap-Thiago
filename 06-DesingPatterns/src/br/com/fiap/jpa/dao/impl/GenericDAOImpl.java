package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDAO;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFooundException;

public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	private EntityManager em;
	
	//atributo que armazena o .class da entidade
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(T entity) {
		em.persist(entity);

	}

	@Override
	public void atulizar(T entity) {
		em.merge(entity);
	}

	@Override
	public T pesquisar(K id) throws KeyNotFooundException {
		T entity = em.find(clazz, id);
		if (entity == null) {
			throw new KeyNotFooundException();
		}
		return null;
	}

	@Override
	public void deletar(K id) throws KeyNotFooundException {
		T entity = pesquisar(id);
		em.remove(entity);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}

package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.bean.Produto;

public interface ProtudoDAO {

	void insert(Produto produto);
	
	List<Produto> getByNome(String nome);
	
	
}

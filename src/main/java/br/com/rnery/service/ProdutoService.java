package br.com.rnery.service;

import br.com.rnery.dao.generics.IGenericDAO;
import br.com.rnery.domain.Produto;
import br.com.rnery.service.generics.GenericService;

public class ProdutoService extends GenericService<Produto> implements IProdutoService{

	public ProdutoService(IGenericDAO<Produto> clienteDAO) {
		super(clienteDAO);
	}

}

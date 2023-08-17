package br.com.rnery.service.generics;

import br.com.rnery.dao.generics.IGenericDAO;
import br.com.rnery.domain.Persistente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;

public abstract class GenericService<T extends Persistente> implements IGenericService<T> {
	
	private IGenericDAO<T> dao;
	
	public GenericService(IGenericDAO<T> clienteDAO) {
		this.dao = clienteDAO;
	}

	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public T consultar(Long chave) {
		return this.dao.consultar(chave);
	}

	@Override
	public void excluir(Long chave) {
		this.dao.excluir(chave);
		
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException {
		return this.dao.alterar(entity);
	}

	

	
}

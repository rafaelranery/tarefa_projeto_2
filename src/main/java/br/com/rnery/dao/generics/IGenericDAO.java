package br.com.rnery.dao.generics;

import java.util.Collection;

import br.com.rnery.domain.Persistente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;

public interface IGenericDAO <T extends Persistente>{
	
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;
	
	public void excluir(Long valor);
	
	public T alterar(T entity) throws TipoChaveNaoEncontradaException;
	
	public T consultar(Long valor);
	
	public Collection<T> buscarTodos();
}

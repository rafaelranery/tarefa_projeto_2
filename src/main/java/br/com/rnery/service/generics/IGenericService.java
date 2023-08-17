package br.com.rnery.service.generics;

import br.com.rnery.domain.Cliente;
import br.com.rnery.domain.Persistente;
import br.com.rnery.domain.Produto;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistente> {

	Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

	T consultar(Long chave);

	void excluir(Long chave);

	T alterar(T entity) throws TipoChaveNaoEncontradaException;

}

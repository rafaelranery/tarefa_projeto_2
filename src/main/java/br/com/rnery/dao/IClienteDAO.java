package br.com.rnery.dao;

import br.com.rnery.dao.generics.IGenericDAO;
import br.com.rnery.domain.Cliente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;

public interface IClienteDAO extends IGenericDAO<Cliente> {

}

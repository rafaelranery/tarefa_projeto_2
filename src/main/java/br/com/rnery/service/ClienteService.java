package br.com.rnery.service;

import br.com.rnery.dao.IClienteDAO;
import br.com.rnery.dao.generics.IGenericDAO;
import br.com.rnery.domain.Cliente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;
import br.com.rnery.service.generics.GenericService;

public class ClienteService extends GenericService<Cliente> implements IClienteService {

	public ClienteService(IGenericDAO<Cliente> clienteDAO) {
		super(clienteDAO);
	}

}

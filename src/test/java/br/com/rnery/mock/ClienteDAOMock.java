package br.com.rnery.mock;

import java.util.Collection;

import br.com.rnery.dao.IClienteDAO;
import br.com.rnery.domain.Cliente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;

public class ClienteDAOMock implements IClienteDAO {

	@Override
	public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(Long valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultar(Long valor) {
		// TODO Auto-generated method stub
		Cliente c = new Cliente();
		c.setCpf(valor);
		return c;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente alterar(Cliente entity) throws TipoChaveNaoEncontradaException {
		return entity;
		// TODO Auto-generated method stub
		
	}

}

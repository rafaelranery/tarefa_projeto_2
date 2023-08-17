package br.com.rnery.mock;

import java.util.Collection;

import br.com.rnery.dao.IProdutoDAO;
import br.com.rnery.domain.Produto;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;

public class ProdutoDAOMock implements IProdutoDAO {

	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void excluir(Long valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto alterar(Produto entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public Produto consultar(Long valor) {
		Produto p = new Produto();
		p.setId(valor);
		return p;
	}

	@Override
	public Collection<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}

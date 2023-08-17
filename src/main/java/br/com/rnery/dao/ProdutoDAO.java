package br.com.rnery.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.rnery.dao.generics.GenericDAO;
import br.com.rnery.domain.Produto;
import br.com.rnery.singletons.SingletonMap;

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {
	
	public ProdutoDAO() {
		super();
		Map<Long, Produto> mapaInterno = (Map<Long, Produto>) SingletonMap.getInstance().getMap().get(getTipoClasse());
		
		if(mapaInterno == null) {
			mapaInterno = new HashMap<>();
			SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
		}
	}

	@Override
	public Class<Produto> getTipoClasse() {
		// TODO Auto-generated method stub
		return Produto.class;
	}

	@Override
	public void atualizarDados(Produto entity, Produto entityCadastrada) {
		entityCadastrada.setId(entity.getId());
		entityCadastrada.setName(entity.getName());
		entityCadastrada.setIsDiscount(entity.getIsDiscount());
	}

}

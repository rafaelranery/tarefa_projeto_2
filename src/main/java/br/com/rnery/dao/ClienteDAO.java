package br.com.rnery.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.rnery.dao.generics.GenericDAO;
import br.com.rnery.domain.Cliente;
import br.com.rnery.singletons.SingletonMap;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
	
	public ClienteDAO() {
		super();
		// necessário criar um mapa no construtor no caso de inicialização da dao. 
		// Sem isso ocorre o erro de executarmos operações de uma DAO sem a presença
		// de um mapa da classe no SingletonMap.
		Map<Long, Cliente> mapaInterno = (Map<Long, Cliente>) SingletonMap.getInstance().getMap().get(getTipoClasse());
		if (mapaInterno == null) {
			mapaInterno = new HashMap<>();
			SingletonMap.getInstance().getMap().put(getTipoClasse(), mapaInterno);
		}
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		// TODO Auto-generated method stub
		return Cliente.class;
	}

	@Override
	public void atualizarDados(Cliente entity, Cliente entityCadastrada) {
		entityCadastrada.setCpf(entity.getCpf());
		entityCadastrada.setCidade(entity.getCidade());
		entityCadastrada.setEnd(entity.getEnd());
		entityCadastrada.setEstado(entity.getEstado());
		entityCadastrada.setNomeCliente(entity.getNomeCliente());
		entityCadastrada.setNumero(entity.getNumero());
		entityCadastrada.setTel(entity.getTel());
	}



}

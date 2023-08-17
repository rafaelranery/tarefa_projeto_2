package br.com.rnery.dao.generics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import br.com.rnery.annotations.TipoChave;
import br.com.rnery.domain.Persistente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;
import br.com.rnery.singletons.SingletonMap;

public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

	private SingletonMap singletonMap;
	
	public abstract Class<T> getTipoClasse();
	
	public abstract void atualizarDados(T entity, T entityCadastrada);
	
	public GenericDAO() {
		this.singletonMap = SingletonMap.getInstance();
	}
	
	public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
		Method[] methods = entity.getClass().getDeclaredMethods();
		
		Long returnVal = null;
		
		for(Method m : methods) {
			if(m.isAnnotationPresent(TipoChave.class)) {
				TipoChave tipoChave = m.getAnnotation(TipoChave.class);
				String nomeMetodo = tipoChave.value();
				try {
					Method method = entity.getClass().getMethod(nomeMetodo);
					returnVal = (Long) method.invoke(entity);
					return returnVal;
				} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
					throw new TipoChaveNaoEncontradaException(
							"Chave principal do objeto " + entity.getClass() + " não encontrada!", e
					);
				}
			}
		}
		if(returnVal == null) {
			String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada!";
			throw new TipoChaveNaoEncontradaException(msg);
		}
		return null;
	}
	
	@Override
	public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
		Map<Long, T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
		Long chave = getChave(entity);
		
		if(mapaInterno.containsKey(chave)) {
			return false;
		}
		
		mapaInterno.put(chave, entity);
		return true;
	}

	@Override
	public void excluir(Long valor) {
		Map<Long, T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
		T objetoCadastrado = mapaInterno.get(valor);
		if(objetoCadastrado != null) {
			mapaInterno.remove(valor, objetoCadastrado);
		}
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException {
		Map<Long, T> mapaInterno = (Map<Long,T>) this.singletonMap.getMap().get(getTipoClasse());
		Long chave = getChave(entity);
		T objetoCadastrado = mapaInterno.get(chave);
		if(objetoCadastrado != null) {
			atualizarDados(entity, objetoCadastrado);
		}
		return mapaInterno.get(chave);
	}

	@Override
	public T consultar(Long valor) {
		Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
		return mapaInterno.get(valor);
	}

	@Override
	public Collection<T> buscarTodos() {
		Map<Long, T> mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
		return mapaInterno.values();
	}

}

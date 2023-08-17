package br.com.rnery.singletons;

import java.util.HashMap;
import java.util.Map;

public class SingletonMap {
	
	private static SingletonMap instance;
	
	protected Map<Class, Map<Long, ?>> map;
	
	private SingletonMap() {
		this.map = new HashMap<>();
	}
	
	public static final SingletonMap getInstance() {
		if(instance == null) {
			instance = new SingletonMap();
		}
		return instance;
	}
	
	public Map<Class, Map<Long, ?>> getMap() {
		return this.map;
	}
}

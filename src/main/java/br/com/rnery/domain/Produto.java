package br.com.rnery.domain;

import br.com.rnery.annotations.TipoChave;

public class Produto extends Persistente {
	private Long id;
	private String name;
	private Boolean isDiscount;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@TipoChave("getId")
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(Boolean isDiscount) {
		this.isDiscount = isDiscount;
	}
	

}

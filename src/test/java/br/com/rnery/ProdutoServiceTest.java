package br.com.rnery;

import org.junit.Before;
import org.junit.Test;

import br.com.rnery.domain.Produto;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;
import br.com.rnery.mock.ProdutoDAOMock;
import br.com.rnery.service.IProdutoService;
import br.com.rnery.service.ProdutoService;
import junit.framework.Assert;

public class ProdutoServiceTest {
	private IProdutoService service;
	private Produto p;
	
	public ProdutoServiceTest() {
		this.service = new ProdutoService(new ProdutoDAOMock());
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		this.p = new Produto();
		p.setId(1l);
		p.setIsDiscount(true);
		p.setName("Cadeira");
		service.cadastrar(p);
	}
	
	@Test
	public void cadastrarProduto() throws TipoChaveNaoEncontradaException {
		Boolean res = service.cadastrar(p);
		Assert.assertTrue(res);
	}
	
	@Test
	public void consultarProduto() {
		Produto pCadastrado  = service.consultar(p.getId());
		Assert.assertNotNull(pCadastrado);
	}
	
	@Test
	public void excluirProduto() {
		service.excluir(p.getId());
	}
	
	@Test 
	public void alterarProduto() throws TipoChaveNaoEncontradaException {
		p.setName("Nome alterado");
		Produto pAtualizado = service.alterar(p);
		
		Assert.assertEquals("Nome alterado", pAtualizado.getName());
	}
}

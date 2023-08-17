package br.com.rnery;

import org.junit.Before;
import org.junit.Test;

import br.com.rnery.dao.IProdutoDAO;
import br.com.rnery.dao.ProdutoDAO;
import br.com.rnery.domain.Produto;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;
import junit.framework.Assert;

public class ProdutoDAOTest {

	private IProdutoDAO dao;
	private Produto p;
	
	public ProdutoDAOTest() {
		this.dao = new ProdutoDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		this.p = new Produto();
		p.setId(1L);
		p.setName("Cadeira");
		p.setIsDiscount(true);
		dao.cadastrar(p);
	}
	
	@Test
	public void pesquisarProduto() {
		Produto pConsultado = dao.consultar(p.getId());
		Assert.assertNotNull(pConsultado);
	}
	
	@Test 
	public void excluirProduto() {
		dao.excluir(p.getId());
	}
	
	@Test
	public void alterarProduto() throws TipoChaveNaoEncontradaException {
		p.setName("Nome Alterado");
		Produto pAtualizado = null;
		
		pAtualizado = dao.alterar(p);
		Assert.assertEquals("Nome Alterado", pAtualizado.getName());
	}
	
	@Test 
	public void cadastrarProduto() throws TipoChaveNaoEncontradaException {
		Produto pNew = new Produto();
		pNew.setId(2L);
		Boolean res = dao.cadastrar(pNew);
		Assert.assertTrue(res);
	}
}

package br.com.rnery;

import org.junit.Before;
import org.junit.Test;

import br.com.rnery.dao.ClienteDAO;
import br.com.rnery.dao.IClienteDAO;
import br.com.rnery.domain.Cliente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;
import br.com.rnery.mock.ClienteDAOMock;
import junit.framework.Assert;

public class ClienteDAOTest {
	private IClienteDAO dao;
	private Cliente c;
	
	public ClienteDAOTest() {
		this.dao = new ClienteDAO();
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		this.c = new Cliente();
		c.setCpf(12345678901L);
		c.setNomeCliente("Rafael");
		c.setCidade("São Paulo");
		c.setEnd("End");
		c.setEstado("SP");
		c.setNumero(63);
		c.setTel(11953616215L);
		dao.cadastrar(c);
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente cConsultado = dao.consultar(c.getCpf());
		Assert.assertNotNull(cConsultado);
	}
	
	@Test 
	public void excluirCliente() {
		dao.excluir(c.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		c.setNomeCliente("Nome Alterado");
		Cliente cAtualizado = null;

		cAtualizado = dao.alterar(c);
		
		Assert.assertEquals("Nome Alterado", cAtualizado.getNomeCliente());
	}
	
	@Test
	public void cadastrarCliente() throws TipoChaveNaoEncontradaException {
		Cliente cNew = new Cliente();
		cNew.setCpf(2L);
		Boolean res = dao.cadastrar(cNew);
		org.junit.Assert.assertTrue(res);
	}
}

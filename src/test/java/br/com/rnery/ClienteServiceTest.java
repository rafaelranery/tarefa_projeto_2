package br.com.rnery;

import org.junit.Before;
import org.junit.Test;

import br.com.rnery.dao.ClienteDAO;
import br.com.rnery.domain.Cliente;
import br.com.rnery.exception.TipoChaveNaoEncontradaException;
import br.com.rnery.mock.ClienteDAOMock;
import br.com.rnery.service.ClienteService;
import br.com.rnery.service.IClienteService;
import junit.framework.Assert;

public class ClienteServiceTest {
	
	private IClienteService service;
	private Cliente c;
	
	public ClienteServiceTest() {
		this.service = new ClienteService(new ClienteDAOMock());
	}
	
	// criamos uma função para realização de processamentos anteriores à qualquer teste
	// através da anotação do JUnit @Before
	// 
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
		service.cadastrar(c);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void pesquisarCliente() {
		// precisaremos criar um cliente para futuramente procurá-lo		
		
		Cliente clienteConsultado = service.consultar(c.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
		
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean res =  service.cadastrar(c);
		Assert.assertTrue(res);
	}
	
	@Test
	public void excluirCliente() {
		service.excluir(c.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		c.setNomeCliente("Nome alterado");
		service.alterar(c);
		
		Assert.assertEquals("Nome alterado", c.getNomeCliente());
	}
}

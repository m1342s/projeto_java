package test.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.ClienteDAO;
import dao.IClienteDAO;
import domain.Cliente;
import generics.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {
	
	private IClienteDAO clienteDAO;
	
	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDAO=new ClienteDAOMock();
		
	}
	
	@Before
	public void init() throws TipoChaveNaoEncontradaException {
	    cliente=new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Rodrigo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(11999999999L);
		
		clienteDAO.cadastrar(cliente);
	}
	
	
	@Test
	public void pesquisarCliente() {
		
	Cliente clienteConsultado=clienteDAO.consultar(cliente.getCpf());
		
	Assert.assertNotNull(clienteConsultado);
		
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno=clienteDAO.cadastrar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteDAO.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Rodrigo Pires");
		clienteDAO.alterar(cliente);
		
		Assert.assertEquals("Rodrigo Pires",cliente.getNome());
	}
		
}

package test;

import dao.IClienteDAO;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import domain.Cliente;
import generics.TipoChaveNaoEncontradaException;
import services.ClienteService;
import services.IClienteService;
import test.dao.ClienteDAOMock;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao=new ClienteDAOMock();
		clienteService=new ClienteService(dao);
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
		
		clienteService.salvar(cliente);
	}
	
	@Test
	public void pesquisarCliente() {
		
		Cliente clienteConsultado=clienteService.buscarPorCPF(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
		
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno=clienteService.salvar(cliente);
		
		Assert.assertTrue(retorno);
	}
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Rodrigo Pires");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Rodrigo Pires",cliente.getNome());
	}
	
	

}

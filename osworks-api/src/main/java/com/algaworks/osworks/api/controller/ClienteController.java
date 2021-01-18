package com.algaworks.osworks.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;
@RestController
public class ClienteController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ClienteRepository clienteRepositoy;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		/*Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		cliente1.setId(1);
		cliente1.setNome("Ellie");
		cliente1.setTelefone("61 99999-7777");
		cliente1.setEmail("ellie@thelastofus");
		
		cliente2.setId(2);
		cliente2.setNome("joel");
		cliente2.setTelefone("61 99999-7778");
		cliente2.setEmail("joelmiller@thelastofus");
		
		
	    clientes.add(cliente1);
		clientes.add(cliente2);*/
		return manager.createQuery("from Cliente", Cliente.class).getResultList();
	}

}

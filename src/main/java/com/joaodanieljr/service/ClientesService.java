package com.joaodanieljr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaodanieljr.model.Cliente;
import com.joaodanieljr.repository.ClienteRepository;

@Service
public class ClientesService {
	
	@Autowired
	public ClienteRepository repo;

	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		repo.persistir(cliente);
		
		
	}

	public void validarCliente(Cliente cliente) {
		
	}
}

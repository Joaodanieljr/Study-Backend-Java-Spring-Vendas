package com.joaodanieljr;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.joaodanieljr.domain.entity.Cliente;
import com.joaodanieljr.domain.repositorio.Clientes;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes){
		return args-> {
			clientes.salvar(new Cliente("Joao"));
			clientes.salvar(new Cliente("Joao2"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}
	
	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);
	}

}

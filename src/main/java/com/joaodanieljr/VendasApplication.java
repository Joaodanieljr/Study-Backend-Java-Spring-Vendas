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
			clientes.salvar(new Cliente("daniel"));
			clientes.salvar(new Cliente("pereira"));
			clientes.salvar(new Cliente("junior"));
			
			List<Cliente> todosClientes = clientes.obterTodos();
			System.out.println("Busca todos os clientes");
			todosClientes.forEach(System.out::println);
			
			todosClientes.forEach(cliente ->{
				cliente.setNome(cliente.getNome() + " Atualizado");
				clientes.atualizar(cliente);
			});
			
			System.out.println("Busca todos os clientes atualizados");
			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			
			System.out.println("Busca todos os clientes apos delete");
			clientes.deletar(1);
			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
			
			System.out.println("Busca todos os clientes que contem JUN");
			clientes.buscarNome("jun").forEach(System.out::println);
		};

	}
	
	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);
	}

}

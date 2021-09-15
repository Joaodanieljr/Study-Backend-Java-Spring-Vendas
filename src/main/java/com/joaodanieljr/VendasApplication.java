package com.joaodanieljr;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.joaodanieljr.domain.entity.Pedido;
import com.joaodanieljr.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.joaodanieljr.domain.entity.Cliente;
import com.joaodanieljr.domain.repository.Clientes;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired Clientes clientes,
			@Autowired Pedidos pedidos){
		return args-> {
			Cliente joao = new Cliente("Joao");
			clientes.save(joao);

			Pedido p_1 = new Pedido();
			p_1.setCliente(joao);
			p_1.setDataPedido(LocalDate.now());
			p_1.setTotal(BigDecimal.valueOf(100));
			pedidos.save(p_1);

			/*Cliente cliente = clientes.findClienteFetchPedidos(joao.getId());
			System.out.println(cliente);
			System.out.println(cliente.getPedidos());*/

			pedidos.findByCliente(joao).forEach(System.out::println);
		};
	}
	
	public static void main(String[] args) {

		SpringApplication.run(VendasApplication.class, args);
	}

}

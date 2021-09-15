package com.joaodanieljr.domain.repository;

import com.joaodanieljr.domain.entity.Cliente;
import com.joaodanieljr.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    Set<Pedido> findByCliente(Cliente cliente);
}

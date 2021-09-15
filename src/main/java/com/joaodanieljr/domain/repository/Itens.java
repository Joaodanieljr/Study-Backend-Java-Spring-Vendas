package com.joaodanieljr.domain.repository;

import com.joaodanieljr.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Itens extends JpaRepository<ItemPedido, Integer> {
}

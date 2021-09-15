package com.joaodanieljr.domain.repository;

import com.joaodanieljr.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = " SELECT * FROM cliente c WHERE c.nome LIKE '%:nome%' ", nativeQuery = true)
    List<Cliente> findByNomeContains(@Param("nome") String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}

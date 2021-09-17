package com.joaodanieljr.service;


import com.joaodanieljr.domain.entity.Pedido;
import com.joaodanieljr.domain.enums.StatusPedido;
import com.joaodanieljr.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar (PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}

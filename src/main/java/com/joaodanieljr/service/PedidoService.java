package com.joaodanieljr.service;


import com.joaodanieljr.domain.entity.Pedido;
import com.joaodanieljr.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar (PedidoDTO dto);
}

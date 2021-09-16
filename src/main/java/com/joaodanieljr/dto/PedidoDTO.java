package com.joaodanieljr.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItensPedidoDTO> itens;

}

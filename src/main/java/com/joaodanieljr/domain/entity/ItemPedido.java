package com.joaodanieljr.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	@Column(name = "quantidade")
	private Integer quantidade;
}

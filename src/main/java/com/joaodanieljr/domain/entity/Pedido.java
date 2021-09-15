package com.joaodanieljr.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido")
	private Set<ItemPedido> itens;

	@Column(name = "data_pedido")
	private LocalDate dataPedido;

	@Column(name = "total", precision = 20, scale = 2)
	private BigDecimal total;
	
	public Pedido() {
	}
	public Pedido(Cliente cliente, LocalDate dataPedido,
			BigDecimal total) {
		this.cliente = cliente;
		this.dataPedido = dataPedido;
		this.total = total;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {this.cliente = cliente;}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Set<ItemPedido> getItens() {return itens;}

	@Override
	public String toString() {
		return "Pedido{" +
				"id=" + id +
				", dataPedido=" + dataPedido +
				", total=" + total +
				'}';
	}
}

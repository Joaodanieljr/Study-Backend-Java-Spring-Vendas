package com.joaodanieljr.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name= "cliente") //SOMENTE QUANDO O NOME DA TABELA É DIFERENTE DA ENTIDADE
@Getter
@Setter
@ToString
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome", length = 100)
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<Pedido> pedidos;

	public Cliente() {
	}

	public Cliente(String nome) {
		this.nome = nome;
	}	
	
	public Cliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
}

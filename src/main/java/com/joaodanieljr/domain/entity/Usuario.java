package com.joaodanieljr.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    @NotBlank(message = "{campo.senha.obrigatorio}")
    private String login;

    @Column(name = "senha")
    @NotBlank(message = "{campo.login.obrigatorio}")
    private String senha;

    @Column(name = "admin")
    private boolean admin;
}

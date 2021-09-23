package com.joaodanieljr.controller;

import com.joaodanieljr.domain.entity.Usuario;
import com.joaodanieljr.dto.CredenciaisDTO;
import com.joaodanieljr.dto.TokenDTO;
import com.joaodanieljr.exceptions.SenhaInvalidaException;
import com.joaodanieljr.security.jwt.JwtService;
import com.joaodanieljr.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        String senhaCrypto = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCrypto);
        return usuarioService.salvar(usuario);
    }

    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciaisDTO){
        try {
            Usuario usuario = Usuario.builder().login(credenciaisDTO.getLogin()).senha(credenciaisDTO.getSenha()).build();
            UserDetails usuarioAutenticado = usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new TokenDTO(usuario.getLogin(), token);
        }catch (UsernameNotFoundException | SenhaInvalidaException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }

}

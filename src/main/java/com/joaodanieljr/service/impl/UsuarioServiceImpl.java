package com.joaodanieljr.service.impl;

import com.joaodanieljr.domain.entity.Usuario;
import com.joaodanieljr.domain.repository.UsuarioRepository;
import com.joaodanieljr.exceptions.SenhaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(userName).orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado"));
        String[] roles = usuario.isAdmin() ? new String[]{"ADMIN", "USER"}: new String[]{"USER"};
        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public UserDetails autenticar(Usuario usuario){
        UserDetails user = loadUserByUsername(usuario.getLogin());
        boolean senhas = passwordEncoder.matches(usuario.getSenha(), user.getPassword());
        if (senhas){
            return user;
        }
        throw new SenhaInvalidaException();
    }
}

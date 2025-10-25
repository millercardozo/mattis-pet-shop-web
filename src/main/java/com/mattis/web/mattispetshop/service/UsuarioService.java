package com.mattis.web.mattispetshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mattis.web.mattispetshop.model.Usuario;
import com.mattis.web.mattispetshop.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Registrar un nuevo usuario
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Autenticar por correo y contraseña (simple)
    public boolean autenticar(String correo, String password) {
        Optional<Usuario> u = usuarioRepository.findByCorreo(correo);
        return u.isPresent() && u.get().getPassword().equals(password);
    }
}

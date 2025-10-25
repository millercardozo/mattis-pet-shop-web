package com.mattis.web.mattispetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mattis.web.mattispetshop.model.Usuario;
import com.mattis.web.mattispetshop.service.UsuarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para registrar usuario
    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "Usuario registrado exitosamente: " + usuario.getCorreo();
    }

    // Endpoint para login
    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean ok = usuarioService.autenticar(usuario.getCorreo(), usuario.getPassword());
        if (ok) return "✅ Autenticación satisfactoria para " + usuario.getCorreo();
        else return "❌ Error en la autenticación: credenciales incorrectas.";
    }
}

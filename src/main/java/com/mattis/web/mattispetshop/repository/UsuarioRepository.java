package com.mattis.web.mattispetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mattis.web.mattispetshop.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}

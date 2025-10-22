package com.mattis.web.mattispetshop.repository;

import com.mattis.web.mattispetshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Spring genera automáticamente todos los métodos CRUD
}

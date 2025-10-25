package com.mattis.web.mattispetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mattis.web.mattispetshop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

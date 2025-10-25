package com.mattis.web.mattispetshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mattis.web.mattispetshop.model.Cliente;
import com.mattis.web.mattispetshop.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos los clientes
    public List<Cliente> listarClientes() { return clienteRepository.findAll(); }

    // Registrar cliente
    public Cliente registrarCliente(Cliente cliente) { return clienteRepository.save(cliente); }

    // Actualizar cliente
    public Cliente actualizarCliente(Cliente cliente) { return clienteRepository.save(cliente); }

    // Buscar por id
    public Optional<Cliente> buscarPorId(Long id) { return clienteRepository.findById(id); }

    // Eliminar cliente
    public void eliminarCliente(Long id) { clienteRepository.deleteById(id); }
}


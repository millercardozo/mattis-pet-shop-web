package com.mattis.web.mattispetshop.service;

import com.mattis.web.mattispetshop.model.Cliente;
import com.mattis.web.mattispetshop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    // Buscar por ID
    public Optional<Cliente> obtenerCliente(Long id) {
        return clienteRepository.findById(id);
    }

    // Guardar (insertar o actualizar)
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Eliminar por ID
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}

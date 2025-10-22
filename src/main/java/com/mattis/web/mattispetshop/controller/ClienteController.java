package com.mattis.web.mattispetshop.controller;

import com.mattis.web.mattispetshop.model.Cliente;
import com.mattis.web.mattispetshop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*") // permite acceder desde front-end o Postman
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos los clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public Optional<Cliente> obtenerPorId(@PathVariable Long id) {
        return clienteService.obtenerCliente(id);
    }

    // Agregar nuevo cliente
    @PostMapping
    public Cliente agregar(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    // Actualizar cliente existente
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setIdCliente(id);
        return clienteService.guardarCliente(cliente);
    }

    // Eliminar cliente
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}

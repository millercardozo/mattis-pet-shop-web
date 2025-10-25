package com.mattis.web.mattispetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mattis.web.mattispetshop.model.Servicio;
import com.mattis.web.mattispetshop.service.ServicioService;

import java.util.List;

@RestController
@RequestMapping("/servicios")
@CrossOrigin(origins = "*")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // Listar servicios
    @GetMapping("/listar")
    public List<Servicio> listarServicios() { return servicioService.listarServicios(); }

    // Registrar servicio
    @PostMapping("/registrar")
    public Servicio registrarServicio(@RequestBody Servicio servicio) { return servicioService.registrarServicio(servicio); }

    // Eliminar servicio
    @DeleteMapping("/eliminar/{id}")
    public void eliminarServicio(@PathVariable Long id) { servicioService.eliminarServicio(id); }
}
package com.mattis.web.mattispetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mattis.web.mattispetshop.model.Cita;
import com.mattis.web.mattispetshop.service.CitaService;

import java.util.List;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // Listar todas las citas
    @GetMapping("/listar")
    public List<Cita> listarCitas() { return citaService.listarCitas(); }

    // Crear una nueva cita
    @PostMapping("/crear")
    public Cita crearCita(@RequestBody Cita cita) { return citaService.crearCita(cita); }

    // Actualizar una cita existente
    @PutMapping("/actualizar")
    public Cita actualizarCita(@RequestBody Cita cita) { return citaService.actualizarCita(cita); }

    // Eliminar una cita
    @DeleteMapping("/eliminar/{id}")
    public void eliminarCita(@PathVariable Long id) { citaService.eliminarCita(id); }
}
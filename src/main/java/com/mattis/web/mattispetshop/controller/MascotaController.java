package com.mattis.web.mattispetshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mattis.web.mattispetshop.model.Mascota;
import com.mattis.web.mattispetshop.service.MascotaService;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    // Obtener todas las mascotas
    @GetMapping("/listar")
    public List<Mascota> listarMascotas() { return mascotaService.listarMascotas(); }

    // Registrar una nueva mascota
    @PostMapping("/registrar")
    public Mascota registrarMascota(@RequestBody Mascota mascota) { return mascotaService.registrarMascota(mascota); }

    // Actualizar una mascota existente
    @PutMapping("/actualizar")
    public Mascota actualizarMascota(@RequestBody Mascota mascota) { return mascotaService.actualizarMascota(mascota); }

    // Eliminar una mascota por ID
    @DeleteMapping("/eliminar/{id}")
    public void eliminarMascota(@PathVariable Long id) { mascotaService.eliminarMascota(id); }
}


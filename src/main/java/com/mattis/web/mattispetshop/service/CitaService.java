package com.mattis.web.mattispetshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mattis.web.mattispetshop.model.Cita;
import com.mattis.web.mattispetshop.repository.CitaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> listarCitas() { return citaRepository.findAll(); }

    public Cita crearCita(Cita cita) { return citaRepository.save(cita); }

    public Cita actualizarCita(Cita cita) { return citaRepository.save(cita); }

    public void eliminarCita(Long id) { citaRepository.deleteById(id); }

    public Optional<Cita> buscarPorId(Long id) { return citaRepository.findById(id); }
}

package com.mattis.web.mattispetshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mattis.web.mattispetshop.model.Servicio;
import com.mattis.web.mattispetshop.repository.ServicioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> listarServicios() { return servicioRepository.findAll(); }

    public Servicio registrarServicio(Servicio servicio) { return servicioRepository.save(servicio); }

    public void eliminarServicio(Long id) { servicioRepository.deleteById(id); }

    public Optional<Servicio> buscarPorId(Long id) { return servicioRepository.findById(id); }
}

package com.mattis.web.mattispetshop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mattis.web.mattispetshop.model.Mascota;
import com.mattis.web.mattispetshop.repository.MascotaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> listarMascotas() { return mascotaRepository.findAll(); }

    public Mascota registrarMascota(Mascota mascota) { return mascotaRepository.save(mascota); }

    public Mascota actualizarMascota(Mascota mascota) { return mascotaRepository.save(mascota); }

    public void eliminarMascota(Long id) { mascotaRepository.deleteById(id); }

    public Optional<Mascota> buscarPorId(Long id) { return mascotaRepository.findById(id); }
}

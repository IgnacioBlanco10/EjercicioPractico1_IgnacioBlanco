/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1_IgnacioBlanco.service;

import com.EjercicioPractico1_IgnacioBlanco.domain.Servicio;
import com.EjercicioPractico1_IgnacioBlanco.repository.ServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nacho
 */
@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> getServicios() {
        return servicioRepository.findAll();
    }

    public Servicio getServicio(Servicio servicio) {
        return servicioRepository.findById(servicio.getId()).orElse(null);
    }

    public void save(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    public void delete(Servicio servicio) {
        servicioRepository.delete(servicio);
    }
}

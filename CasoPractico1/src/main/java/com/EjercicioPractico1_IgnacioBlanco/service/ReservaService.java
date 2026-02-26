/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1_IgnacioBlanco.service;

import com.EjercicioPractico1_IgnacioBlanco.domain.Reserva;
import com.EjercicioPractico1_IgnacioBlanco.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nacho
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReserva(Reserva reserva) {
        return reservaRepository.findById(reserva.getId()).orElse(null);
    }

    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public void delete(Reserva reserva) {
        reservaRepository.delete(reserva);
    }
}
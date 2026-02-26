/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1_IgnacioBlanco.controllers;

import com.EjercicioPractico1_IgnacioBlanco.domain.Reserva;
import com.EjercicioPractico1_IgnacioBlanco.domain.Servicio;
import com.EjercicioPractico1_IgnacioBlanco.service.ReservaService;
import com.EjercicioPractico1_IgnacioBlanco.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author nacho
 */
@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("reservas", reservaService.getReservas());

        Reserva reserva = new Reserva();
        reserva.setServicio(new Servicio());
        model.addAttribute("reserva", reserva);

        model.addAttribute("servicios", servicioService.getServicios());

        return "/reserva/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);

        if (reserva.getServicio() == null) {
            reserva.setServicio(new Servicio());
        }

        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicioService.getServicios());
        return "/reserva/modifica";
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EjercicioPractico1_IgnacioBlanco.controllers;

import com.EjercicioPractico1_IgnacioBlanco.domain.Servicio;
import com.EjercicioPractico1_IgnacioBlanco.service.CategoriaService;
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
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("servicios", servicioService.getServicios());

        Servicio servicio = new Servicio();
        servicio.setCategoria(new com.EjercicioPractico1_IgnacioBlanco.domain.Categoria());

        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categoriaService.getCategorias());

        return "/servicio/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Servicio servicio) {
        servicioService.save(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Servicio servicio) {
        servicioService.delete(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Servicio servicio, Model model) {
        servicio = servicioService.getServicio(servicio);

        if (servicio.getCategoria() == null) {
            servicio.setCategoria(new com.EjercicioPractico1_IgnacioBlanco.domain.Categoria());
        }

        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categoriaService.getCategorias());

        return "/servicio/modifica";
    }
}

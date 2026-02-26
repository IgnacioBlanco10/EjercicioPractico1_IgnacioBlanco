/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.EjercicioPractico1_IgnacioBlanco.repository;

import com.EjercicioPractico1_IgnacioBlanco.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nacho
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}

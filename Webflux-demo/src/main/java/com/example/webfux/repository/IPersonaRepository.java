/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webfux.repository;

import com.example.webfux.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author christianpineda
 */
public interface IPersonaRepository {
    Mono<Persona> registrar(Persona persona);
    Mono<Persona> modificar(Persona persona);
    Flux<Persona> listar();
    Mono<Persona> listarPorId(Integer id);
    Mono<Void> eliminar(Integer id);
    
}

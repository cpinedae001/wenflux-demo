/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webfux.repository.imp;

import com.example.webfux.model.Persona;
import com.example.webfux.repository.IPersonaRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author christianpineda
 */
@Repository
public class PersonaImp implements IPersonaRepository {

    private static final Logger log = LoggerFactory.getLogger(PersonaImp.class);

    @Override
    public Mono<Persona> registrar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Mono<Persona> modificar(Persona persona) {
        log.info(persona.toString());
        return Mono.just(persona);
    }

    @Override
    public Flux<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Carol"));
        personas.add(new Persona(2, "Cristhian"));
        personas.add(new Persona(3, "Daniela"));
        return Flux.fromIterable(personas);
    }

    @Override
    public Mono<Persona> listarPorId(Integer id) {
        return Mono.just(new Persona(id, "Raquel"));
    }

    @Override
    public Mono<Void> eliminar(Integer id) {
        return Mono.empty();
    }

}

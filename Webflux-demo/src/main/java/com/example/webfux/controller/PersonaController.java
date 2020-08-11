/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webfux.controller;

import com.example.webfux.model.Persona;
import com.example.webfux.repository.IPersonaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author christianpineda
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {

    private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private IPersonaRepository repo;

    @GetMapping("listar")
    public Flux<Persona> listar() {
        return repo.listar();
    }

    @GetMapping("buscarid/{id}")
    public Mono<Persona> porId(@PathVariable("id") Integer id) {
        return repo.listarPorId(id);
    }

    @PostMapping("registrar")
    public Mono<Persona> registrar(@RequestBody Persona per) {
        return repo.registrar(per);
    }

    @PutMapping("modificar")
    public Mono<Persona> modificar(@RequestBody Persona per) {
        return repo.modificar(per);
    }

    @GetMapping("eliminar/{id}")
    public Mono<Void> eliminar(@PathVariable("id") Integer id) {
        return repo.listarPorId(id)
                .flatMap(p -> repo.eliminar(p.getIdPersona()));
    }

}

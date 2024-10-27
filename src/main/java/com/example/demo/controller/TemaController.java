package com.example.demo.controller;

import com.example.demo.entity.Tema;
import com.example.demo.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    private TemaService temaService;

    // request: ver temas
    @GetMapping
    public List<Tema> obtenerTemas() {
        return temaService.obtenerTemas();
    }

    // request: buscar tema por nombre
    @GetMapping("/buscar")
    public Optional<Tema> obtenerTemaPorNombre(@RequestParam String nombre) {
        return temaService.obtenerTemaPorNombre(nombre);
    }

    // request: crear tema
    @PostMapping
    public Tema crearTema(@RequestParam String nombre, @RequestParam String descripcion) {
        return temaService.crearTema(new Tema(nombre, descripcion));
    }

    // request: modificar tema
    @PutMapping
    public Tema modificarTema(@RequestParam String nombre, @RequestParam String descripcion) {
        return temaService.actualizarTema(new Tema(nombre, descripcion), nombre);
    }

    // request: eliminar tema
    @DeleteMapping
    public void eliminarNombre(@RequestParam String nombre) {
        temaService.eliminarTema(nombre);
    }
}
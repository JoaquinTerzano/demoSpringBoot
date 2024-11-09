package com.example.demo.controller;

import com.example.demo.entity.Tema;
import com.example.demo.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
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
    public Optional<Tema> obtenerTemaPorNombre(@RequestParam("nombre") String nombre) {
        return temaService.obtenerTemaPorNombre(nombre);
    }

    // request: crear tema
    @PostMapping
    public Tema crearTema(@RequestBody Tema tema) {
        return temaService.crearTema(tema);
    }

    // request: modificar tema
    @PutMapping
    public Tema actualizarTema(@RequestBody Tema tema) {
        return temaService.actualizarTema(tema);
    }

    // request: eliminar tema
    @DeleteMapping
    public void eliminarNombre(@RequestParam("id") Integer id) {
        temaService.eliminarTema(id);
    }
}
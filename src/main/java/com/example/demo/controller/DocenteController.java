package com.example.demo.controller;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Docente;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/docentes")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;
    @Autowired
    private CursoRepository cursoRepository;

    // request: ver docentes
    @GetMapping
    public List<Docente> obtenerDocentes() {
        return docenteService.obtenerDocentes();
    }

    // request buscar docente por legajo
    @GetMapping("/buscar")
    public Optional<Docente> obtenerDocentePorLegajo(@RequestParam("legajo") Integer legajo) {
        return docenteService.obtenerDocentePorLegajo(legajo);
    }

    // request: crear docente
    @PostMapping
    public Docente crearDocente(@RequestBody Docente docente) {
        return docenteService.crearDocente(docente);
    }

    // request: modificar docente
    @PutMapping
    public Docente actualizarDocente(@RequestBody Docente docente) {
        return docenteService.actualizarDocente(docente);
    }

    // request: eliminar docente
    @DeleteMapping
    public void eliminarDocente(@RequestParam("id") Integer id) {
        docenteService.eliminarDocente(id);
    }

    // request: ver cursos del docente
    @GetMapping("/cursos")
    public List<Curso> obtenerCursos(@RequestParam Integer legajo) {
        return cursoRepository.findByDocente(legajo);
    }
}

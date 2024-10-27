package com.example.demo.controller;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;
import com.example.demo.entity.CursoAlumno;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.CursoAlumnoRepository;
import com.example.demo.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoAlumnoRepository cursoAlumnoRepository;

    // request: ver cursos
    @GetMapping
    public List<Curso> obtenerCursos() {
        return cursoService.obtenerCursos();
    }

    // request: buscar curso por fechaFin
    @GetMapping("/buscar")
    public List<Curso> obtenerCursoPorFechaFin(@RequestParam("fechaFin") String fechaFin) {
        return cursoService.obtenerCursoPorFechaFin(fechaFin);
    }

    // request: crear curso
    @PostMapping
    public Curso crearCurso(@RequestParam String tema, @RequestParam String fechaInicio, @RequestParam String fechaFin, @RequestParam Integer docente, @RequestParam Float precio) {
        return cursoService.crearCurso(new Curso(tema, fechaInicio, fechaFin, docente, precio));
    }

    // request: modificar curso
    @PutMapping
    public Curso modificarCurso(@RequestParam("id") Integer id, @RequestParam String tema, @RequestParam String fechaInicio, @RequestParam String fechaFin, @RequestParam Integer docente, @RequestParam Float precio) {
        return cursoService.actualizarCurso(new Curso(tema, fechaInicio, fechaFin, docente, precio), id);
    }

    // request: eliminar curso
    @DeleteMapping
    public void eliminarCurso(@RequestParam("id") Integer id) {
        cursoService.eliminarCurso(id);
    }

    // request: ver alumnos del curso
    @GetMapping("/alumnos")
    public List<Optional<Alumno>> obtenerAlumnosPorCurso(@RequestParam("id") Integer id) {
        var cursoAlumnoList = cursoAlumnoRepository.findByCursoId(id);
        var alumnoIdStream = cursoAlumnoList.stream().map(CursoAlumno::getAlumnoId);
        return (alumnoIdStream.map(i -> alumnoRepository.findById(i))).collect(Collectors.toList());
    }
}

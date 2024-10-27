package com.example.demo.controller;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;
import com.example.demo.entity.CursoAlumno;
import com.example.demo.repository.CursoAlumnoRepository;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.AlumnoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private CursoAlumnoRepository cursoAlumnoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    // request: ver alumnos
    @GetMapping
    public List<Alumno> obtenerAlumnos() {
        return alumnoService.obtenerAlumnos();
    }

    // request: buscar alumno por id
    @GetMapping("/buscar")
    public Optional<Alumno> obtenerAlumnoPorId(@RequestParam Long id) {
        return alumnoService.obtenerAlumnoPorId(id);
    }

    // request: crear alumno
    @PostMapping
    public Alumno crearAlumno(@RequestParam String nombre, @RequestParam String fechaNacimiento) {
        return alumnoService.crearAlumno(new Alumno(nombre, fechaNacimiento));
    }

    // request: modificar alumno
    @PutMapping
    public Alumno actualizarAlumno(@RequestParam Long id, @RequestParam String nombre, @RequestParam String fechaNacimiento) {
        return alumnoService.actualizarAlumno(new Alumno(nombre, fechaNacimiento), id);
    }

    // request: eliminar alumno
    @DeleteMapping
    public void eliminarAlumno(@RequestParam Long id) {
        alumnoService.eliminarAlumno(id);
    }

    // request: ver cursos del alumno
    @GetMapping("/cursos")
    public List<Optional<Curso>> obtenerCursosPorAlumno(@RequestParam Long id) {
        var cursoAlumnoList = cursoAlumnoRepository.findByAlumnoId(id);
        var cursoIdStream = cursoAlumnoList.stream().map(CursoAlumno::getCursoId);
        return (cursoIdStream.map(i -> cursoRepository.findById(i))).collect(Collectors.toList());
    }

    // request: inscribir alumno al curso
    @PutMapping("/inscribir")
    public void inscribirAlumno(@RequestParam("alumnoId") Long alumnoId, @RequestParam("cursoId") int cursoId) {
        alumnoService.inscribirAlumno(alumnoId, cursoId);
    }

    // request: dar de baja del curso al alumno
    @PutMapping("/darDeBaja")
    public void darDeBajaAlumno(@RequestParam("alumnoId") Long alumnoId, @RequestParam("cursoId") int cursoId) {
        alumnoService.darDeBajaAlumno(alumnoId, cursoId);
    }
}

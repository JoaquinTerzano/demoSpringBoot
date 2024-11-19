package com.ddsw.backend.controller;

import com.ddsw.backend.entity.Alumno;
import com.ddsw.backend.entity.Curso;
import com.ddsw.backend.entity.CursoAlumno;
import com.ddsw.backend.repository.CursoAlumnoRepository;
import com.ddsw.backend.repository.CursoRepository;
import com.ddsw.backend.service.AlumnoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins="http://localhost:4200")
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
    public Optional<Alumno> obtenerAlumnoPorId(@RequestParam("id") Long id) {
        return alumnoService.obtenerAlumnoPorId(id);
    }

    // request: crear alumno
    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.crearAlumno(alumno);
    }

    // request: modificar alumno
    @PutMapping
    public Alumno actualizarAlumno(@RequestBody Alumno alumno) {
        return alumnoService.actualizarAlumno(alumno);
    }

    // request: eliminar alumno
    @DeleteMapping
    public void eliminarAlumno(@RequestParam("id") Long id) {
        alumnoService.eliminarAlumno(id);
    }

    // request: ver cursos del alumno
    @GetMapping("/cursos")
    public List<Optional<Curso>> obtenerCursosPorAlumno(@RequestParam("id") Long id) {
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

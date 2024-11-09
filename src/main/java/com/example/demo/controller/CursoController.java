package com.example.demo.controller;

import com.example.demo.entity.Alumno;
import com.example.demo.entity.Curso;
import com.example.demo.entity.CursoAlumno;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.CursoAlumnoRepository;
import com.example.demo.service.AlumnoService;
import com.example.demo.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;
    @Autowired
    private AlumnoService alumnoService;
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
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    // request: modificar curso
    @PutMapping
    public Curso actualizarCurso(@RequestBody Curso curso) {
        return cursoService.actualizarCurso(curso);
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

    // request: inscribir alumno al curso
    @PostMapping("/alumnos")
    public Alumno inscribirAlumno(@RequestParam Integer id, @RequestBody Alumno alumno) {
        alumnoService.crearAlumno(alumno);
        alumnoService.inscribirAlumno(alumno.getId(), id);
        return alumno;
    }

    // request: dar de baja alumno
    @PutMapping("/alumnos")
    public Alumno darDeBajaAlumno(@RequestParam Integer id, @RequestBody Alumno alumno) {
        alumnoService.darDeBajaAlumno(alumno.getId(), id);
        return alumno;
    }
}

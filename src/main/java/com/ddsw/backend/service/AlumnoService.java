package com.ddsw.backend.service;

import com.ddsw.backend.entity.Alumno;
import com.ddsw.backend.entity.CursoAlumno;
import com.ddsw.backend.repository.AlumnoRepository;
import com.ddsw.backend.repository.CursoAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoAlumnoRepository cursoAlumnoRepository;

    public List<Alumno> obtenerAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    public Alumno crearAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno actualizarAlumno(Alumno alumno) {
        Optional<Alumno> antiguo = alumnoRepository.findById(alumno.getId());
        if (antiguo.isPresent()) {
            Alumno actualizado = antiguo.get();
            actualizado.setId(alumno.getId());
            actualizado.setNombre(alumno.getNombre());
            actualizado.setFechaNacimiento(alumno.getfechaNacimiento());
            return alumnoRepository.save(actualizado);
        }
        return null;
    }

    public void inscribirAlumno(Long alumnoId, int cursoId) {
        cursoAlumnoRepository.save(new CursoAlumno(cursoId, alumnoId));
    }

    public void darDeBajaAlumno(Long alumnoId, int cursoId) {
        cursoAlumnoRepository.deleteById(cursoAlumnoRepository.findByCursoIdAndAlumnoId(cursoId, alumnoId).getId());
    }
}

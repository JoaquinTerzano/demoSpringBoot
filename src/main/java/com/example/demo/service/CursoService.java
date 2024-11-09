package com.example.demo.service;

import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Integer id) {
        cursoRepository.deleteById(id);
    }

    public List<Curso> obtenerCursoPorFechaFin(String fecha) {
        return cursoRepository.findByFechaFinContaining(fecha);
    }

    public Curso actualizarCurso(Curso curso) {
        Optional<Curso> antiguo = cursoRepository.findById(curso.getId());
        if (antiguo.isPresent()) {
            Curso actualizado = antiguo.get();
            actualizado.setId(curso.getId());
            actualizado.setTema(curso.getTema());
            actualizado.setDocente(curso.getDocente());
            actualizado.setFechaInicio(curso.getFechaInicio());
            actualizado.setFechaFin(curso.getFechaFin());
            actualizado.setPrecio(curso.getPrecio());
            return cursoRepository.save(actualizado);
        }
        return null;
    }
}

package com.example.demo.service;

import com.example.demo.repository.DocenteRepository;
import com.example.demo.entity.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> obtenerDocentes() {
        return docenteRepository.findAll();
    }

    public Optional<Docente> obtenerDocentePorLegajo(Integer legajo) {
        return docenteRepository.findByLegajo(legajo);
    }

    public Docente crearDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    public void eliminarDocente(Integer legajo) {
        Optional<Docente> docente = obtenerDocentePorLegajo(legajo);
        docente.ifPresent(doc -> docenteRepository.deleteById(doc.getId()));
    }

    public Docente actualizarDocente(Docente docente, Integer legajo) {
        Optional<Docente> docenteExistente = docenteRepository.findByLegajo(legajo);
        if (docenteExistente.isPresent()) {
            Docente actualizado = docenteExistente.get();
            actualizado.setId(docente.getId());
            actualizado.setNombre(docente.getNombre());
            actualizado.setLegajo(docente.getLegajo());
            return docenteRepository.save(actualizado);
        }
        return null;
    }
}
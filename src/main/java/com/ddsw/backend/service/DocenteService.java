package com.ddsw.backend.service;

import com.ddsw.backend.repository.DocenteRepository;
import com.ddsw.backend.entity.Docente;
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

    public void eliminarDocente(Integer id) {
        docenteRepository.deleteById(id);
    }

    public Docente actualizarDocente(Docente docente) {
        Optional<Docente> docenteExistente = docenteRepository.findByLegajo(docente.getLegajo());
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

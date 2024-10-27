package com.example.demo.service;

import com.example.demo.entity.Docente;
import com.example.demo.entity.Tema;
import com.example.demo.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    public List<Tema> obtenerTemas() {
        return temaRepository.findAll();
    }

    public Optional<Tema> obtenerTemaPorNombre(String nombre) {
        return temaRepository.findByNombre(nombre);
    }

    public Tema crearTema(Tema tema) {
        return temaRepository.save(tema);
    }

    public Tema actualizarTema(Tema tema, String nombre) {
        Optional<Tema> antiguo = obtenerTemaPorNombre(nombre);
        if (antiguo.isPresent()) {
            Tema actualizado = antiguo.get();
            actualizado.setId(tema.getId());
            actualizado.setNombre(tema.getNombre());
            actualizado.setDescripcion(tema.getDescripcion());
            return temaRepository.save(actualizado);
        }
        return null;
    }

    public void eliminarTema(String nombre) {
        Optional<Tema> tema = obtenerTemaPorNombre(nombre);
        tema.ifPresent(tem -> temaRepository.deleteById(tem.getId()));
    }
}

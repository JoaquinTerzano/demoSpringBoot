package com.ddsw.backend.repository;

import com.ddsw.backend.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    List<Curso> findByFechaFinContaining(String fecha);
    List<Curso> findByDocente(int docente);
}

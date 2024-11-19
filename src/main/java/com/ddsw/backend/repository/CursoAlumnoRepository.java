package com.ddsw.backend.repository;

import com.ddsw.backend.entity.CursoAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoAlumnoRepository extends JpaRepository<CursoAlumno, Long> {
    List<CursoAlumno> findByCursoId(int cursoId);
    List<CursoAlumno> findByAlumnoId(Long alumnoId);
    CursoAlumno findByCursoIdAndAlumnoId(int cursoId, Long alumnoId);
}

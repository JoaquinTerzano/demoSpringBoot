package com.example.demo.repository;

import com.example.demo.entity.CursoAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoAlumnoRepository extends JpaRepository<CursoAlumno, Long> {
    List<CursoAlumno> findByCursoId(int cursoId);
    List<CursoAlumno> findByAlumnoId(Long alumnoId);
    CursoAlumno findByCursoIdAndAlumnoId(int cursoId, Long alumnoId);
}

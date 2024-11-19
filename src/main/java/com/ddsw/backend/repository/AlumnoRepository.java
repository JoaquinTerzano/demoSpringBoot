package com.ddsw.backend.repository;

import com.ddsw.backend.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    //List<Alumno> findByCurso(String nombre);
}

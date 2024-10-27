package com.example.demo.repository;

import com.example.demo.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    //List<Alumno> findByCurso(String nombre);
}

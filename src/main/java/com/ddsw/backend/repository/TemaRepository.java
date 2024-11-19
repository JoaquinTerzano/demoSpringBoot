package com.ddsw.backend.repository;

import com.ddsw.backend.entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {
    Optional<Tema> findByNombre(String nombre);
}

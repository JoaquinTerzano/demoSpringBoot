package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto indica que el ID será generado automáticamente
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="fechaNacimiento")
    private String fechaNacimiento; // DD-MM-YYYY
    /*
    @ManyToMany(mappedBy="alumnos")
    private Set<Curso> cursos = new HashSet<>();
    */

    public Alumno() {}

    public Alumno(String nombre, String fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getfechaNacimiento() {
        return fechaNacimiento;
    }
/*
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }
*/
}

package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto indica que el ID será generado automáticamente
    private int id;
    @Column(name="tema")
    private String tema; // nombre del tema
    @Column(name="fechaInicio")
    private String fechaInicio;
    @Column(name="fechaFin")
    private String fechaFin;
    @Column(name="docente")
    private Integer docente; // legajo del docente
    @Column(name="precio")
    private Float precio;
    /*
    @ManyToMany
    @JoinTable(name="curso_alumno",
               joinColumns=@JoinColumn(name="curso_id"),
               inverseJoinColumns=@JoinColumn(name="alumno_id"))
    private Set<Alumno> alumnos = new HashSet<>();
     */

    public Curso() {}

    public Curso(String tema, String fechaInicio, String fechaFin, Integer docente, Float precio) {
        this.tema = tema;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.docente = docente;
        this.precio = precio;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getId() { return id; }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setDocente(Integer docente) {
        this.docente = docente;
    }

    public Integer getDocente() {
        return docente;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getPrecio() {
        return precio;
    }
    /*
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }
    */
}

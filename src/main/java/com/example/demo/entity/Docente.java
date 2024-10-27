package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto indica que el ID será generado automáticamente
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="legajo", unique=true)
    private Integer legajo;

    public Docente() {}

    public Docente(String nombre, Integer legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getId() { return id; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Integer getLegajo() {
        return legajo;
    }
}

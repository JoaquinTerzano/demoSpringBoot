package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="temas")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto indica que el ID será generado automáticamente
    private int id;
    @Column(name="nombre", unique=true)
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;

    public Tema() {}

    public Tema(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getId() { return id; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

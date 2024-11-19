package com.ddsw.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="curso_alumno")
public class CursoAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto indica que el ID será generado automáticamente
    private Long id;
    @Column(name="curso_id")
    private int cursoId;
    @Column(name="alumno_id")
    private Long alumnoId;

    public CursoAlumno() {}

    public CursoAlumno(int cursoId, Long alumnoId) {
        this.cursoId = cursoId;
        this.alumnoId = alumnoId;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public int getCursoId() {return cursoId;}
    public void setCursoId(int cursoId) {this.cursoId = cursoId;}
    public Long getAlumnoId() {return alumnoId;}
    public void setAlumnoId(Long alumnoId) {this.alumnoId = alumnoId;}
}

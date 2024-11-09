/*
CREATE TABLE IF NOT EXISTS alumnos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    fecha_nacimiento VARCHAR(10) -- DD/MM/YYYY
);

CREATE TABLE IF NOT EXISTS docentes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    legajo INT UNIQUE
);

CREATE TABLE IF NOT EXISTS temas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) UNIQUE,
    descripcion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tema VARCHAR(255), -- nombre del tema
    fecha_inicio VARCHAR(10), -- DD/MM/YYYY
    fecha_fin VARCHAR(10), -- DD/MM/YYYY
    docente INT, -- legajo del docente
    precio FLOAT
);

CREATE TABLE IF NOT EXISTS curso_alumno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    curso_id INT, -- id del curso
    alumno_id BIGINT -- id del alumno
);
*/
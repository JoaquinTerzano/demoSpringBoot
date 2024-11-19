INSERT INTO alumnos (nombre, fecha_nacimiento) VALUES
                                                   ('Joaquin Terzano', '21-05-2001'),
                                                   ('Mariano Baldovino', '05-09-2003');

INSERT INTO docentes (nombre, legajo) VALUES
                                          ('Paul Dirac', 1234),
                                          ('Albert Einstein', 5678),
                                          ('Sergio Viera', 8080);

INSERT INTO temas (nombre, descripcion) VALUES
    ('Mecánica Cuántica', 'Se introducen conceptos como la cuantización de la energía, donde las partículas solo pueden tener ciertos niveles de energía discretos, y la superposición, que permite que un sistema exista en múltiples estados simultáneamente.'),
    ('Relatividad General', 'Se describe la gravitación como la curvatura del espacio-tiempo causada por la masa. Los objetos masivos deforman su entorno, y esta curvatura guía el movimiento de otros cuerpos, reemplazando la noción clásica de fuerza gravitacional.');

INSERT INTO cursos (tema, fecha_inicio, fecha_fin, docente, precio) VALUES
    ('Mecánica cuántica', '12-03-2025', '23-11-2025', 1234, 1000),
    ('Relatividad general', '12-03-2025', '23-11-2025', 5678, 1000);
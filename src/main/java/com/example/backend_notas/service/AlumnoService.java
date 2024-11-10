package com.example.backend_notas.service;

import java.util.List;
import java.util.Optional;

import com.example.backend_notas.entity.Alumno;

public interface AlumnoService {
	Alumno create(Alumno Alumno);
    Alumno update(Alumno Alumnoo);
    Optional<Alumno> read(Long id);
    void delete(Long id);
    List<Alumno> readAll();
}

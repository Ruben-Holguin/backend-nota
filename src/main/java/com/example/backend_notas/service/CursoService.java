package com.example.backend_notas.service;

import java.util.List;
import java.util.Optional;

import com.example.backend_notas.entity.Curso;

public interface CursoService {
	Curso create(Curso Curso);
    Curso update(Curso Cursoo);
    Optional<Curso> read(Long id);
    void delete(Long id);
    List<Curso> readAll();
}

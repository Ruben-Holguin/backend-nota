package com.example.backend_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_notas.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}

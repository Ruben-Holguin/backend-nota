package com.example.backend_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.backend_notas.entity.Alumno;

@Service
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}

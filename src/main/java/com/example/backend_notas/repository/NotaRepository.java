package com.example.backend_notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_notas.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long>{

}

package com.example.backend_notas.service;

import java.util.List;
import java.util.Optional;

import com.example.backend_notas.entity.Nota;

public interface NotaService {
	Nota create(Nota Nota);
    Nota update(Nota Notao);
    Optional<Nota> read(Long id);
    void delete(Long id);
    List<Nota> readAll();
}

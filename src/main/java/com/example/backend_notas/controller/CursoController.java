package com.example.backend_notas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_notas.entity.Curso;
import com.example.backend_notas.service.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/Cursos")
@CrossOrigin(origins = "http://localhost:4200")
public class CursoController {
	@Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> readAll(){
        try {
            List<Curso> Cursos = cursoService.readAll();
            if(Cursos.isEmpty()) {
                return new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Cursos, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Curso> crear(@Valid @RequestBody Curso Curso) {
        try {
            Curso c = cursoService.create(Curso);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoId(@PathVariable("id") Long id){
        try {
            Curso c = cursoService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> delCurso(@PathVariable("id") Long id){
        try {
            cursoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCurso(@PathVariable("id") Long id, @Valid @RequestBody Curso Curso){

        Optional<Curso> c = cursoService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(cursoService.update(Curso), HttpStatus.OK);
        }

    }
}

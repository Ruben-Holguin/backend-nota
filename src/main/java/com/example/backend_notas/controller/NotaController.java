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

import com.example.backend_notas.entity.Nota;
import com.example.backend_notas.service.NotaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/Notas")
@CrossOrigin(origins = "http://localhost:4200")
public class NotaController {
	@Autowired
    private NotaService notaService;

	@GetMapping
    public ResponseEntity<List<Nota>> readAll(){
        try {
            List<Nota> Notas = notaService.readAll();
            if(Notas.isEmpty()) {
                return new ResponseEntity<List<Nota>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Notas, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Nota> crear(@Valid @RequestBody Nota Nota) {
        try {
            Nota c = notaService.create(Nota);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaId(@PathVariable("id") Long id){
        try {
            Nota c = notaService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Nota> delNota(@PathVariable("id") Long id){
        try {
            notaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateNota(@PathVariable("id") Long id, @Valid @RequestBody Nota Nota){

        Optional<Nota> c = notaService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(notaService.update(Nota), HttpStatus.OK);
        }

    }
}

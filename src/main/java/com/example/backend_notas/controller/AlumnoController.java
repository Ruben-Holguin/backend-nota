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

import com.example.backend_notas.entity.Alumno;
import com.example.backend_notas.service.AlumnoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/Alumnos")
@CrossOrigin(origins = "http://localhost:4200")
public class AlumnoController {
	@Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> readAll(){
        try {
            List<Alumno> Alumnos = alumnoService.readAll();
            if(Alumnos.isEmpty()) {
                return new ResponseEntity<List<Alumno>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Alumnos, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping
    public ResponseEntity<Alumno> crear(@Valid @RequestBody Alumno Alumno) {
        try {
            Alumno c = alumnoService.create(Alumno);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoId(@PathVariable("id") Long id){
        try {
            Alumno c = alumnoService.read(id).get();
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Alumno> delAlumno(@PathVariable("id") Long id){
        try {
            alumnoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable("id") Long id, @Valid @RequestBody Alumno Alumno){

        Optional<Alumno> c = alumnoService.read(id);
        if(c.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(alumnoService.update(Alumno), HttpStatus.OK);
        }

    }
}

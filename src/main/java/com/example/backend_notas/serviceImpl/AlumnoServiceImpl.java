package com.example.backend_notas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.backend_notas.entity.Alumno;
import com.example.backend_notas.repository.AlumnoRepository;
import com.example.backend_notas.service.AlumnoService;

@Repository
public class AlumnoServiceImpl implements AlumnoService{

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Override
	public Alumno create(Alumno Alumno) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(Alumno);
	}

	@Override
	public Alumno update(Alumno Alumnoo) {
		// TODO Auto-generated method stub
		return alumnoRepository.save(Alumnoo);
	}

	@Override
	public Optional<Alumno> read(Long id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

}

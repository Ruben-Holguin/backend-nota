package com.example.backend_notas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.backend_notas.entity.Curso;
import com.example.backend_notas.repository.CursoRepository;
import com.example.backend_notas.service.CursoService;

@Repository
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso create(Curso Curso) {
		// TODO Auto-generated method stub
		return cursoRepository.save(Curso);
	}

	@Override
	public Curso update(Curso Cursoo) {
		// TODO Auto-generated method stub
		return cursoRepository.save(Cursoo);
	}

	@Override
	public Optional<Curso> read(Long id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(id);
	}

	@Override
	public List<Curso> readAll() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

}

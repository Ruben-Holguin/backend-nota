package com.example.backend_notas.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_notas.entity.Nota;
import com.example.backend_notas.repository.NotaRepository;
import com.example.backend_notas.service.NotaService;

@Service
public class NotaServiceImpl implements NotaService{

	@Autowired
	private NotaRepository notaRepository;
	
	@Override
	public Nota create(Nota Nota) {
		// TODO Auto-generated method stub
		return notaRepository.save(Nota);
	}

	@Override
	public Nota update(Nota Notao) {
		// TODO Auto-generated method stub
		return notaRepository.save(Notao);
	}

	@Override
	public Optional<Nota> read(Long id) {
		// TODO Auto-generated method stub
		return notaRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		notaRepository.deleteById(id);
	}

	@Override
	public List<Nota> readAll() {
		// TODO Auto-generated method stub
		return notaRepository.findAll();
	}

}

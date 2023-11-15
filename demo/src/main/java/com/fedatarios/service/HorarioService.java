package com.fedatarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedatarios.model.Horarios;
import com.fedatarios.repository.HorarioRepositorio;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepositorio horarioRepo;
	
	public List<Horarios> listarHorarios() {
		return horarioRepo.findAll();
	}
	public void guardarHorario(Horarios horario) {
		horarioRepo.save(horario);
	}
	
	public Horarios obtenerHorario(Long id) {
		return horarioRepo.findById(id).get();
	}
	
}

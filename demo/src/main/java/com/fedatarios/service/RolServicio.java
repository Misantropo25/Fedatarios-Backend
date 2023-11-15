package com.fedatarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedatarios.model.Rol;
import com.fedatarios.repository.RolRepository;

@Service
public class RolServicio {
	
	@Autowired
	private RolRepository repositorio;
	
	public List<Rol> listarRoles(){
		return repositorio.findAll();
	}
	
	public void guardarRol(Rol rol) {
		repositorio.save(rol);
	}
	
	public Rol obtenerRol(Long id) {
		return repositorio.findById(id).get();
	}

}

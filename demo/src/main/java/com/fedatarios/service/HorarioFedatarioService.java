package com.fedatarios.service;

import com.fedatarios.model.HorarioFedatario;
import com.fedatarios.repository.HorarioFedatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioFedatarioService {

    @Autowired
    private HorarioFedatarioRepository horarioFedatarioRepository;

    public HorarioFedatario save(HorarioFedatario horarioFedatario) {
        return horarioFedatarioRepository.save(horarioFedatario);
    }

    public List<HorarioFedatario> findByUsuario_IdUsuario(Long usuarioId) {
        return horarioFedatarioRepository.findByUsuario_IdUsuario(usuarioId);
    }

    public Optional<HorarioFedatario> findById(Long id) {
        return horarioFedatarioRepository.findById(id);
    }

    public void deleteById(Long id) {
        horarioFedatarioRepository.deleteById(id);
    }

    public List<HorarioFedatario> findAll() {
        return horarioFedatarioRepository.findAll();
    }
}

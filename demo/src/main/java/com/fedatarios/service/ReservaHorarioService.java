package com.fedatarios.service;

import com.fedatarios.model.ReservaHorario;
import com.fedatarios.repository.ReservaHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaHorarioService {

    private final ReservaHorarioRepository reservaHorarioRepository;

    @Autowired
    public ReservaHorarioService(ReservaHorarioRepository reservaHorarioRepository) {
        this.reservaHorarioRepository = reservaHorarioRepository;
    }

    public List<ReservaHorario> findAll() {
        return reservaHorarioRepository.findAll();
    }

    public Optional<ReservaHorario> findById(Long id) {
        return reservaHorarioRepository.findById(id);
    }

    public ReservaHorario save(ReservaHorario reservaHorario) {
        return reservaHorarioRepository.save(reservaHorario);
    }

    public void deleteById(Long id) {
        reservaHorarioRepository.deleteById(id);
    }
}
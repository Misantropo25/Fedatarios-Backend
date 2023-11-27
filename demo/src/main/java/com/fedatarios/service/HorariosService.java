package com.fedatarios.service;

import com.fedatarios.model.Horarios;
import com.fedatarios.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HorariosService {

    private final HorariosRepository horariosRepository;

    @Autowired
    public HorariosService(HorariosRepository horariosRepository) {
        this.horariosRepository = horariosRepository;
    }

    public List<Horarios> findAll() {
        return horariosRepository.findAll();
    }

    public Optional<Horarios> findById(Long id) {
        return horariosRepository.findById(id);
    }

    public Horarios save(Horarios horario) {
        return horariosRepository.save(horario);
    }

    public void deleteById(Long id) {
        horariosRepository.deleteById(id);
    }
}

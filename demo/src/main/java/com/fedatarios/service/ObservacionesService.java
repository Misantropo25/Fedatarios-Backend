package com.fedatarios.service;

import com.fedatarios.model.Observaciones;
import com.fedatarios.repository.ObservacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ObservacionesService {

    private final ObservacionesRepository observacionesRepository;

    @Autowired
    public ObservacionesService(ObservacionesRepository observacionesRepository) {
        this.observacionesRepository = observacionesRepository;
    }

    public List<Observaciones> findAll() {
        return observacionesRepository.findAll();
    }

    public Optional<Observaciones> findById(Long id) {
        return observacionesRepository.findById(id);
    }

    public Observaciones save(Observaciones observacion) {
        return observacionesRepository.save(observacion);
    }

    public void deleteById(Long id) {
        observacionesRepository.deleteById(id);
    }
}

package com.fedatarios.service;

import com.fedatarios.model.Legajo;
import com.fedatarios.repository.LegajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegajoService {

    private final LegajoRepository legajoRepository;

    @Autowired
    public LegajoService(LegajoRepository legajoRepository) {
        this.legajoRepository = legajoRepository;
    }

    public List<Legajo> findAll() {
        return legajoRepository.findAll();
    }

    public Optional<Legajo> findById(Long id) {
        return legajoRepository.findById(id);
    }

    public Legajo save(Legajo legajo) {
        return legajoRepository.save(legajo);
    }

    public void deleteById(Long id) {
        legajoRepository.deleteById(id);
    }
}
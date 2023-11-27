package com.fedatarios.service;

import com.fedatarios.dto.DatosReniec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DatosReniecService {

    private final RestTemplate restTemplate;

    @Autowired
    public DatosReniecService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Optional<DatosReniec> obtenerDatosPorDNI(String dni) {
        try {
            String url = "http://tramitedemo.regioncusco.gob.pe/reniec/"+dni;
            DatosReniec datos = restTemplate.getForObject(url, DatosReniec.class);
            return Optional.ofNullable(datos);
        } catch (Exception e) {
            // Manejar excepción si el API no está disponible o el DNI no es válido
            return Optional.empty();
        }
    }
}

package com.fedatarios.repository;

import com.fedatarios.model.HorarioFedatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioFedatarioRepository extends JpaRepository<HorarioFedatario, Long> {
    List<HorarioFedatario> findByUsuario_IdUsuario(Long idUsuario);
}
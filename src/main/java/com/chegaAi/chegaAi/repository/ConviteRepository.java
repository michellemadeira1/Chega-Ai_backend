package com.chegaAi.chegaAi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegaAi.chegaAi.model.Convite;

@Repository
public interface ConviteRepository extends JpaRepository<Convite, Long> {
    List<Convite> findByEventoId(Long eventoId);
    List<Convite> findByConvidadoId(Long convidadoId);
}
package com.chegaAi.chegaAi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegaAi.chegaAi.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByOrganizadorId(Long organizadorId);
    List<Evento> findByCategoriaId(Long categoriaId);
}
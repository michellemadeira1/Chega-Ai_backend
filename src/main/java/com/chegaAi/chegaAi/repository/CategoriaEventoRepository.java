package com.chegaAi.chegaAi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chegaAi.chegaAi.model.CategoriaEvento;

@Repository
public interface CategoriaEventoRepository extends JpaRepository<CategoriaEvento, Long> {
}
package com.chegaAi.chegaAi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chegaAi.chegaAi.model.CategoriaEvento;
import com.chegaAi.chegaAi.repository.CategoriaEventoRepository;

@Service
public class CategoriaEventoService {

    @Autowired
    private CategoriaEventoRepository categoriaEventoRepository;

    public List<CategoriaEvento> listarTodas() {
        return categoriaEventoRepository.findAll();
    }

    public Optional<CategoriaEvento> buscarPorId(Long id) {
        return categoriaEventoRepository.findById(id);
    }

    public CategoriaEvento salvar(CategoriaEvento categoriaEvento) {
        return categoriaEventoRepository.save(categoriaEvento);
    }

    public void deletar(Long id) {
        categoriaEventoRepository.deleteById(id);
    }
}

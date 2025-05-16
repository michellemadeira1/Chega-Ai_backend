package com.chegaAi.chegaAi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chegaAi.chegaAi.model.Convite;
import com.chegaAi.chegaAi.repository.ConviteRepository;

@Service
public class ConviteService {

    @Autowired
    private ConviteRepository conviteRepository;

    public List<Convite> listarTodos() {
        return conviteRepository.findAll();
    }

    public Optional<Convite> buscarPorId(Long id) {
        return conviteRepository.findById(id);
    }

    public List<Convite> listarPorEvento(Long eventoId) {
        return conviteRepository.findByEventoId(eventoId);
    }

    public List<Convite> listarPorConvidado(Long convidadoId) {
        return conviteRepository.findByConvidadoId(convidadoId);
    }

    public Convite salvar(Convite convite) {
        return conviteRepository.save(convite);
    }

    public void deletar(Long id) {
        conviteRepository.deleteById(id);
    }
}
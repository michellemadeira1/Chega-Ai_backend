package com.chegaAi.chegaAi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chegaAi.chegaAi.model.Evento;
import com.chegaAi.chegaAi.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> buscarPorId(Long id) {
        return eventoRepository.findById(id);
    }

    public List<Evento> listarPorOrganizador(Long organizadorId) {
        return eventoRepository.findByOrganizadorId(organizadorId);
    }

    public Evento salvar(Evento evento) {
        return eventoRepository.save(evento);
    }

    public void deletar(Long id) {
        eventoRepository.deleteById(id);
    }
}

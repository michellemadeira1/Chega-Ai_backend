package com.chegaAi.chegaAi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chegaAi.chegaAi.model.Convite;
import com.chegaAi.chegaAi.services.ConviteService;

@RestController
@RequestMapping("/convites")
@CrossOrigin("*")
public class ConviteController {

    @Autowired
    private ConviteService conviteService;

    @GetMapping
    public ResponseEntity<List<Convite>> listarTodos() {
        return ResponseEntity.ok(conviteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convite> buscarPorId(@PathVariable Long id) {
        return conviteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<Convite>> listarPorEvento(@PathVariable Long eventoId) {
        return ResponseEntity.ok(conviteService.listarPorEvento(eventoId));
    }

    @GetMapping("/convidado/{convidadoId}")
    public ResponseEntity<List<Convite>> listarPorConvidado(@PathVariable Long convidadoId) {
        return ResponseEntity.ok(conviteService.listarPorConvidado(convidadoId));
    }

    @PostMapping
    public ResponseEntity<Convite> salvar(@RequestBody Convite convite) {
        return ResponseEntity.ok(conviteService.salvar(convite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        conviteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

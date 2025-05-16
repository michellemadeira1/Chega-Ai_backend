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

import com.chegaAi.chegaAi.model.CategoriaEvento;
import com.chegaAi.chegaAi.services.CategoriaEventoService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaEventoController {

    @Autowired
    private CategoriaEventoService categoriaEventoService;

    @GetMapping
    public ResponseEntity<List<CategoriaEvento>> listarTodas() {
        return ResponseEntity.ok(categoriaEventoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaEvento> buscarPorId(@PathVariable Long id) {
        return categoriaEventoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CategoriaEvento> salvar(@RequestBody CategoriaEvento categoriaEvento) {
        return ResponseEntity.ok(categoriaEventoService.salvar(categoriaEvento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaEventoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

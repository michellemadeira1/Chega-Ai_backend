package com.chegaAi.chegaAi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class CategoriaEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Evento> eventos;

  public CategoriaEvento() {}

public CategoriaEvento(Long id, @NotBlank String nome, List<Evento> eventos) {
	super();
	this.id = id;
	this.nome = nome;
	this.eventos = eventos;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public List<Evento> getEventos() {
	return eventos;
}

public void setEventos(List<Evento> eventos) {
	this.eventos = eventos;
}
  
  
}

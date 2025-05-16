package com.chegaAi.chegaAi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Convite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "convidado_id")
    private Usuario convidado;

    @Enumerated(EnumType.STRING)
    private StatusConvite status;

    public enum StatusConvite {
        PENDENTE,
        ACEITO,
        RECUSADO
    }

   public Convite () {}

public Convite(Long id, Evento evento, Usuario convidado, StatusConvite status) {
	super();
	this.id = id;
	this.evento = evento;
	this.convidado = convidado;
	this.status = status;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Evento getEvento() {
	return evento;
}

public void setEvento(Evento evento) {
	this.evento = evento;
}

public Usuario getConvidado() {
	return convidado;
}

public void setConvidado(Usuario convidado) {
	this.convidado = convidado;
}

public StatusConvite getStatus() {
	return status;
}

public void setStatus(StatusConvite status) {
	this.status = status;
}
   
   
}

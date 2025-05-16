package com.chegaAi.chegaAi.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    private String descricao;

    @NotNull
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    private Usuario organizador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEvento categoria;

    @OneToMany(mappedBy = "evento")
    private List<Convite> convites;

    public Evento () {}

	public Evento(Long id, @NotBlank String titulo, String descricao, @NotNull LocalDateTime dataHora,
			Usuario organizador, Endereco endereco, CategoriaEvento categoria, List<Convite> convites) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.organizador = organizador;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}

	
    
    
}

package com.digitalNation;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name= "carti")

public class Carte {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String titlu;
	
	@Column(nullable = false)
	private String author;
	
	@OneToMany(mappedBy = "carte")
	private List<Imprumut> imprumuturi = new ArrayList<>();
	
	@Column(nullable = false)
    private boolean disponibila = true;  // inițial cartea este disponibilă
	
	public Carte(Long id, String titlu, String author, boolean disponibila) {
		super();
		
		this.titlu = titlu;
		this.author = author;
		this.disponibila = true;
	}
	
	public Carte() {
	}
	

	
	public boolean isDisponibila() {
		return disponibila;
	}

	public void setDisponibila(boolean disponibila) {
		this.disponibila = disponibila;
	}

	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}

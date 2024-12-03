package com.digitalNation;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity

public class Imprumut {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "carte_id" , nullable = false)
    private Carte carte;
	
	@ManyToOne
	@JoinColumn(name = "cititor_id", nullable = false)
    private Cititor cititor;
	
	
	@Column(nullable = false)
	private Date dataImprumut;

	private Date dataReturnare;

	private boolean returnat = false;
    
    
	public Imprumut() {
		super();
	}


	public Imprumut(Long id, Carte carte, Cititor cititor, Date dataImprumut, Date dataReturnare, boolean returnat) {
		super();
		
		this.carte = carte;
		this.cititor = cititor;
		this.dataImprumut = dataImprumut;
		this.dataReturnare = dataReturnare;
		this.returnat = false;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	public Cititor getCititor() {
		return cititor;
	}
	public void setCititor(Cititor cititor) {
		this.cititor = cititor;
	}
	public Date getDataImprumut() {
		return dataImprumut;
	}
	public void setDataImprumut(Date dataImprumut) {
		this.dataImprumut = dataImprumut;
	}
	public Date getDataReturnare() {
		return dataReturnare;
	}
	public void setDataReturnare(Date dataReturnare) {
		this.dataReturnare = dataReturnare;
	}
	public boolean isReturnat() {
		return returnat;
	}
	public void setReturnat(boolean returnat) {
		this.returnat = returnat;
	}
    
    

}

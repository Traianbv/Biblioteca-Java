package com.digitalNation;

import java.util.Date;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@DiscriminatorValue("CITITOR")

public class Cititor extends Persoana{
	
	@Temporal(TemporalType.DATE)
    private Date dataInscrieri;
    
    private boolean abonamentActiv;
	
    @OneToMany(mappedBy = "cititor")
    private List<Imprumut> imprumuturi;
    
    public Cititor() {
        super();
        this.dataInscrieri = new Date(); // setăm data curentă la creare
        this.abonamentActiv = true;      // implicit activ
    }
	
	
	
	
	public Date getDataInscrieri() {
		return dataInscrieri;
	}
	public void setDataInscrieri(Date dataInscrieri) {
		this.dataInscrieri = dataInscrieri;
	}
	public boolean isAbonamentActiv() {
		return abonamentActiv;
	}
	public void setAbonamentActiv(boolean abonamentActiv) {
		this.abonamentActiv = abonamentActiv;
	}

}

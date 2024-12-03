package com.digitalNation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import repository.CarteRepository;
import repository.CititorRepository;
import repository.ImprumutRepository;

@Service

public class BibliotecaService {
	
	@Autowired
    private CititorRepository cititorRepository; 
	
	@Autowired
	private CarteRepository carteRepository;
	
	@Autowired
	private ImprumutRepository imprumutRepository;
	
	public Cititor adaugaCititor(String nume, String email, String telefon) {
        Cititor cititor = new Cititor();
        cititor.setName(nume);
        cititor.setEmail(email);
        cititor.setTelefon(telefon);
        return cititorRepository.save(cititor);
    }
    
    public List<Cititor> getCititoriActivi() {
        return cititorRepository.findByAbonamentActiv(true);
    }
    
    // Metodă de căutare după nume
    public List<Cititor> getCititoriDupaNume(String nume) {
        return cititorRepository.findByName(nume);
    }
	
	@Transactional
	public Imprumut imprumutaCarte(Long carteId , Long cititorId) {
		
		Carte carte = carteRepository.findById(carteId).orElseThrow(() -> new RuntimeException("Carete negasita"));
		
		if (!carte.isDisponibila()) {
			throw new RuntimeException("Cartea nu este disponibila");
		}
		
		
		 // Găsește cititorul
	    Cititor cititor = cititorRepository.findById(cititorId)
	        .orElseThrow(() -> new RuntimeException("Cititor negasit"));
	    
	    // Marchează cartea ca fiind împrumutată
	    carte.setDisponibila(false);
        carteRepository.save(carte);  //
	 
		
		//Creaza imprumutul
		Imprumut imprumut = new Imprumut();
		
		imprumut.setCarte(carte);
		imprumut.setCititor(cititor);
		imprumut.setDataImprumut(new Date());
		
		
		// Convertim corect LocalDate în Date
	    LocalDate dataReturnare = LocalDate.now().plusDays(14);
	    Date dataReturnareDate = Date.from(
	        dataReturnare.atStartOfDay(ZoneId.systemDefault()).toInstant()
	    );
	    imprumut.setDataReturnare(dataReturnareDate);
	    
	    return imprumutRepository.save(imprumut);
		
	}
	
	@Transactional
	public void returneazaCarte (Long imprumutId) {
		
		Imprumut imprumut = imprumutRepository.findById(imprumutId).orElseThrow(() -> new RuntimeException("Imprumut Negasit"));
		
		if (imprumut.isReturnat()) {
			
			throw new RuntimeException("Cartea a fost deja returnată");
		}
		
		//marcheaza imprumutul ca returnat
		imprumut.setReturnat(true);
		imprumut.setDataReturnare(new Date());
		imprumutRepository.save(imprumut);
		
		//Marcheaza cartea ca disponibila
		Carte carte = imprumut.getCarte();
		carte.setDisponibila(true);
		carteRepository.save(carte);
	}
	
	public Carte adaugaCarte(String titlu, String author) {
		
		Carte carte = new Carte();
		carte.setTitlu(titlu);
		carte.setAuthor(author);
		carte.setDisponibila(true);
		return carteRepository.save(carte);
		
		
	}
	
	public List<Carte> getCartiDisponibile() {
        return carteRepository.findByDisponibila(true);
    }
	
	public List<Carte> getToateCartile() {
	    return carteRepository.findAll();
	}
	

}

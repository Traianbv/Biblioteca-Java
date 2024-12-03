package com.digitalNation;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class BibliotecaControler {
	
	@Autowired
	private BibliotecaService bibliotecaService;
	
    @GetMapping("/")
	public String home() {
	      return "home";
	    }
    
    
    @GetMapping("/cititori/adauga")
    public String formularAdaugareCititor() {
        return "adauga-cititor";
    }

    @PostMapping("/cititori/adauga")
    public String adaugaCititor(
            @RequestParam String nume,
            @RequestParam String email,
            @RequestParam String telefon,
            RedirectAttributes redirectAttributes) {
        try {
            bibliotecaService.adaugaCititor(nume, email, telefon);
            redirectAttributes.addFlashAttribute("success", "Cititor adăugat cu succes!");
            return "redirect:/cititori/adauga";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/cititori/adauga";
        }
    }
    
    @GetMapping("/cititori")
    public String listaCititori(Model model) {
        model.addAttribute("cititori", bibliotecaService.getCititoriActivi());
        return "cititori";
    }
	
 // Procesare împrumut
    @GetMapping("/imprumut")
    public String formularImprumut(Model model) {
        model.addAttribute("cartiDisponibile", bibliotecaService.getCartiDisponibile());
        model.addAttribute("cititori", bibliotecaService.getCititoriActivi());
        return "imprumut";
    }

    @PostMapping("/imprumut")
    public String imprumutaCarte(
            @RequestParam Long carteId,
            @RequestParam Long cititorId,
            RedirectAttributes redirectAttributes) {
        try {
            bibliotecaService.imprumutaCarte(carteId, cititorId);
            redirectAttributes.addFlashAttribute("success", "Carte împrumutată cu succes!");
            return "redirect:/carti";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/imprumut";
        }
    }
    
    @PostMapping("/returnare/{carteId}")
    public String returneazaCarte(@PathVariable Long carteId, RedirectAttributes redirectAttributes) {
        try {
            bibliotecaService.returneazaCarte(carteId);
            redirectAttributes.addFlashAttribute("success", "Carte returnată cu succes!");
            return "redirect:/carti";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/carti";
        }
    }
	
	@GetMapping("/carti/disponibile")
    public String cartiDisponibile(Model model) {
        model.addAttribute("carti", bibliotecaService.getCartiDisponibile());
        return "carti-disponibile";
    }
	
	@PostMapping("/adaugaCarte")
	public String adaugaCarte(@RequestParam String titlu, @RequestParam String author) {
        bibliotecaService.adaugaCarte(titlu, author);
        return "redirect:carti";
    }
	
	 @GetMapping("/carti/adauga")
	    public String formularAdaugareCarte() {
	        return "adaugaCarte";
	    }
	
	
	@GetMapping("/carti")
	    public String listaCarti(Model model) {
	        model.addAttribute("carti", bibliotecaService.getToateCartile());
	        return "carti";
	    }
	
	
	
	
	

}

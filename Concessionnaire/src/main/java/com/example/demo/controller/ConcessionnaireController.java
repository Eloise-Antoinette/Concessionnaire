package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Magasin;
import com.example.demo.model.Voiture;
import com.example.demo.service.ConcessionnaireService;

@RestController
public class ConcessionnaireController {
	
	@Autowired
	ConcessionnaireService myService;
	
	@GetMapping("/getMagasin")
	public List<Magasin> getMagasin() {
		return myService.findAllMagasins();
	}
	
	@GetMapping("/getMagasinsProches")
	public List<Magasin> getMagasinProche(@RequestParam("magasin") String magasinName) {
		return myService.findAllMagasinsProches(magasinName).getMagasinsProches();
		
	}
	
	@GetMapping("/voitures") 
	public List<Voiture> getAllVoitures() {
		return myService.findAllVoitures();
	}
	
	
	@GetMapping("/voitures/{id}")
	public Optional<Voiture> getVoiture(@PathVariable String id) {
		int idVoiture = Integer.parseInt(id);
		return myService.findVoiture(idVoiture);
	}
	
	
	@PostMapping("/voitures/creer")
	public boolean creerVoiture(@RequestBody Voiture nouvelleVoiture) {
		return myService.creerVoiture(nouvelleVoiture);
	}

	
	@PutMapping("/voitures/modifier/{id}")
	public boolean modifierVoiture(@RequestBody Voiture nouvelleVoiture) {		
		return myService.modifierVoiture(nouvelleVoiture);
	}
	
	
	@DeleteMapping("/voitures/supprimer/{id}")
	public void supprimerVoiture(@PathVariable String id) {
		int idVoiture = Integer.parseInt(id);
		myService.supprimerVoiture(idVoiture);
	}
}

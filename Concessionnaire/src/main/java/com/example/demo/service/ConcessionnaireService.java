package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Magasin;
import com.example.demo.model.Voiture;
import com.example.demo.repository.MagasinRepository;
import com.example.demo.repository.VoitureRepository;


@Service
public class ConcessionnaireService {
	
	//Instanciation des repositories JPA
	@Autowired
	MagasinRepository magasinRepo;
	@Autowired
	VoitureRepository voitureRepo;

	
	
	//méthodes de classes
	public List<Magasin> findAllMagasins() {
		List<Magasin> magasins = magasinRepo.findAll();
		return magasins;
	}
	
	public Magasin findAllMagasinsProches(String name){
		Magasin magasins = magasinRepo.findByName(name);
		return magasins;	
	}
	

	public List<Voiture> findAllVoitures() {
		List<Voiture> voitures = voitureRepo.findAll();
		return voitures;
	}
	
	public Optional<Voiture> findVoiture(int id) {
		return voitureRepo.findById(id);
	}
	
	public boolean creerVoiture(Voiture voiture) {
		return voitureRepo.save(voiture) != null;
	}
	
	
	public boolean modifierVoiture(Voiture voiture) {
		return voitureRepo.save(voiture) != null;
	}
	
	public void supprimerVoiture(int id) {
		voitureRepo.deleteById(id);
	}
	
	public List<Voiture> getVoitureByNbPlacesAndMagasinVilleName(int nbPlaces, String magasinVilleName){
		return voitureRepo.getModeleByNbPlacesAndMagasin_ville_nameEquals(nbPlaces, magasinVilleName);
	}
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.demo.model.Voiture;

public interface VoitureRepository   extends JpaRepository<Voiture, Integer>{
    /**
     * This function retrieve the same results as the following SQL query
     * 
     * SELECT modele, prix, reserve, magasins.name FROM voitures,
     *  magasins, villes WHERE voitures.magasin = magasins.id AND voitures.nb_places = 5 
     *  AND magasins.ville = villes.id AND villes.name = 'Montpellier';
     * 
     * @param nbPlaces
     * @param ville
     * @return a list of cars
     */
    List<Voiture> getModeleByNbPlacesAndMagasin_ville_nameEquals(int nbPlaces, String ville);
}




package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Magasin;


public interface MagasinRepository extends JpaRepository<Magasin, Integer> {
	
	 Magasin findByName(String name);

}

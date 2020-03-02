package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Magasin;
import com.example.demo.model.Moto;

public interface MagasinRepository extends JpaRepository<Magasin, Integer> {
	
	 Magasin findByName(String name);

}

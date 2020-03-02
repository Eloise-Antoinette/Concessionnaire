package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "magasins")
public class Magasin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
	private Ville ville;
	
	@JoinTable(
			  name = "magasins_proches", 
			  joinColumns = @JoinColumn(name = "magasin_id"),
			  inverseJoinColumns = @JoinColumn(name = "magasin_proche_id"))
	private List<Magasin> magasinsProches;

}

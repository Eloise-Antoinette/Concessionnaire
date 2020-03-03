package com.example.demo.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Liasion à la base de donnée via JPA
@Entity
@Table(name = "magasins")
public class Magasin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@JoinColumn(name ="ville")
	@ManyToOne
	private Ville ville;
	
	
	@JsonIgnoreProperties({"magasinsProches"})
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			  name = "magasins_proches", 
			  joinColumns = @JoinColumn(name = "magasin_id"),
			  inverseJoinColumns = @JoinColumn(name = "magasin_proche_id"))
	private List<Magasin> magasinsProches;

	
	//Getters & setters
	public List<Magasin> getMagasinsProches() {
		return magasinsProches;
	}

	public void setMagasinsProches(List<Magasin> magasinsProches) {
		this.magasinsProches = magasinsProches;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}


}

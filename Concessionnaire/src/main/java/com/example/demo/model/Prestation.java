package com.example.demo.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prestations")
public class Prestation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String label;
	private float tarif;
	
	@ManyToMany
	@JoinTable(
			  name = "join_mag_pres", 
			  joinColumns = @JoinColumn(name = "magasin_id"),
			  inverseJoinColumns = @JoinColumn(name = "prestation_id"))
	private List<Magasin> magasins;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public List<Magasin> getMagasins() {
		return magasins;
	}

	public void setMagasins(List<Magasin> magasins) {
		this.magasins = magasins;
	}

	
}

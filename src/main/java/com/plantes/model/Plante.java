package com.plantes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plante {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_plante;
	
	private String nom;
	private String origine;
	private String dimension;
	private String rusticite;
	private String floraison;
	private String exposition;
	private String terrain;
	private String liens;
	
	
	public Plante(Long id_plante, String nom, String origine, String dimension, String rusticite, String floraison,
			String exposition, String terrain, String liens) {
		this.id_plante = id_plante;
		this.nom = nom;
		this.origine = origine;
		this.dimension = dimension;
		this.rusticite = rusticite;
		this.floraison = floraison;
		this.exposition = exposition;
		this.terrain = terrain;
		this.liens = liens;
	}


	public Plante() {
	}


	public Long getId_plante() {
		return id_plante;
	}


	public void setId_plante(Long id_plante) {
		this.id_plante = id_plante;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getOrigine() {
		return origine;
	}


	public void setOrigine(String origine) {
		this.origine = origine;
	}


	public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
		this.dimension = dimension;
	}


	public String getRusticite() {
		return rusticite;
	}


	public void setRusticite(String rusticite) {
		this.rusticite = rusticite;
	}


	public String getFloraison() {
		return floraison;
	}


	public void setFloraison(String floraison) {
		this.floraison = floraison;
	}


	public String getExposition() {
		return exposition;
	}


	public void setExposition(String exposition) {
		this.exposition = exposition;
	}


	public String getTerrain() {
		return terrain;
	}


	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}


	public String getLiens() {
		return liens;
	}


	public void setLiens(String liens) {
		this.liens = liens;
	}


	@Override
	public String toString() {
		return "Plante [id_plante=" + id_plante + ", nom=" + nom + ", origine=" + origine + ", dimension=" + dimension
				+ ", rusticite=" + rusticite + ", floraison=" + floraison + ", exposition=" + exposition + ", terrain="
				+ terrain + ", liens=" + liens + "]";
	}
	
	
	




}

package com.plantes.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;



@Entity
public class Plante {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id_plante")
	private Long id;
	
	private String nom;
	private String origine;
	private String dimension;
	private String rusticite;
	private String floraison;
	private String exposition;
	private String terrain;
	private String commentaire;
	private String liens;
	@Column(name= "main_image")
	private String mainImage;
	
	@OneToMany(mappedBy="image", cascade = CascadeType.ALL)
	private Collection<Image> image;
	
	// Constructeurs
	
	public Plante() {
	}


	public Plante(Long id, String nom, String origine, String dimension, String rusticite, String floraison,
			String exposition, String terrain,String commentaire, String liens, String mainImage) {
		this.id = id;
		this.nom = nom;
		this.origine = origine;
		this.dimension = dimension;
		this.rusticite = rusticite;
		this.floraison = floraison;
		this.exposition = exposition;
		this.terrain = terrain;
		this.commentaire = commentaire;
		this.liens = liens;
		this.mainImage = mainImage;
	
	}

	
	// Getters and setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public String getLiens() {
		return liens;
	}


	public void setLiens(String liens) {
		this.liens = liens;
	}


	public String getMainImage() {
		return mainImage;
	}


	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	// To String
	
	@Override
	public String toString() {
		return "Plante [id_plante=" + id + ", nom=" + nom + ", origine=" + origine + ", dimension=" + dimension
				+ ", rusticite=" + rusticite + ", floraison=" + floraison + ", exposition=" + exposition + ", terrain="
				+ terrain + ", commentaire=" + commentaire + ", liens=" + liens + ", mainImage=" + mainImage + "]";
	}

// transient to display maiImage in view

	@Transient
	public String getMainImagePath() {
		if (id == null || mainImage == null) {
			return null;
		}
		
		return "/plante-images/" + id + "/" + mainImage;
	}
	

	
	
	
	




}

package com.plantes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;



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
	@Column(name= "main_image")
	private String mainImage;
	@Column(name= "extra_image1")
	private String extraImage1;
	@Column(name= "extra_image2")
	private String extraImage2;
	@Column(name= "extra_image3")
	private String extraImage3;
	
	
	public Plante(Long id_plante, String nom, String origine, String dimension, String rusticite, String floraison,
			String exposition, String terrain, String liens, String mainImage, String extraImage1, String extraImage2,
			String extraImage3) {
		this.id_plante = id_plante;
		this.nom = nom;
		this.origine = origine;
		this.dimension = dimension;
		this.rusticite = rusticite;
		this.floraison = floraison;
		this.exposition = exposition;
		this.terrain = terrain;
		this.liens = liens;
		this.mainImage = mainImage;
		this.extraImage1 = extraImage1;
		this.extraImage2 = extraImage2;
		this.extraImage3 = extraImage3;
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


	public String getMainImage() {
		return mainImage;
	}


	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}


	public String getExtraImage1() {
		return extraImage1;
	}


	public void setExtraImage1(String extraImage1) {
		this.extraImage1 = extraImage1;
	}


	public String getExtraImage2() {
		return extraImage2;
	}


	public void setExtraImage2(String extraImage2) {
		this.extraImage2 = extraImage2;
	}


	public String getExtraImage3() {
		return extraImage3;
	}


	public void setExtraImage3(String extraImage3) {
		this.extraImage3 = extraImage3;
	}


	@Override
	public String toString() {
		return "Plante [id_plante=" + id_plante + ", nom=" + nom + ", origine=" + origine + ", dimension=" + dimension
				+ ", rusticite=" + rusticite + ", floraison=" + floraison + ", exposition=" + exposition + ", terrain="
				+ terrain + ", liens=" + liens + ", mainImage=" + mainImage + ", extraImage1=" + extraImage1
				+ ", extraImage2=" + extraImage2 + ", extraImage3=" + extraImage3 + "]";
	}
	
	
	@Transient
	public String getMainImagePath() {
		if (id_plante == null || mainImage == null) return null;
		
		return "/plante-images"+ id_plante + "/" + mainImage;
	}
	
	
	




}

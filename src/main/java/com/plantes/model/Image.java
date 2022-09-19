package com.plantes.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_image;
	private String url;
		
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="id_plante")
	private Plante plante;
	
	public Image() {
	}

	public Image(Long id_image, Plante plante, String url) {
		this.id_image = id_image;
		this.plante = plante;
		this.url = url;
	}

	public Long getId_image() {
		return id_image;
	}

	public void setId_image(Long id_image) {
		this.id_image = id_image;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Image [id_image=" + id_image + ", plante=" + plante + ", url=" + url + "]";
	}
}

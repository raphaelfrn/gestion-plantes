package com.plantes.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Image {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_image;
	private String image;
		
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="id_plante")
	private Plante plante;
	
	public Image() {
	}

	public Image(Long id_image, String image, Plante plante) {
		this.id_image = id_image;
		this.image = image;
		this.plante = plante;
	}

	public Long getId_image() {
		return id_image;
	}

	public void setId_image(Long id_image) {
		this.id_image = id_image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Plante getPlante() {
		return plante;
	}

	public void setPlante(Plante plante) {
		this.plante = plante;
	}

	@Override
	public String toString() {
		return "Image [id_image=" + id_image + ", image=" + image + ", plante=" + plante + "]";
	}

	@Transient
	public String getImagePath() {
		if (plante.getId() == null || image == null) {
			return null;
		}
		
		return "/plante-images/" + plante.getId() + "/" + image;
	}


}

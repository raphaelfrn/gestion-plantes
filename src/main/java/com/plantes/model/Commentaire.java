package com.plantes.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commentaire {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_commentaire;
	@Column(length = 1500) 
	private String commentaire;
	
	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn(name="id_plante")
	private Plante plante;
	
	
	public Commentaire(Long id_commentaire, String commentaire, Plante plante) {
		this.id_commentaire = id_commentaire;
		this.commentaire = commentaire;
		this.plante = plante;
	
	}


	public Commentaire() {
	}


	public Long getId_commentaire() {
		return id_commentaire;
	}


	public void setId_commentaire(Long id_commentaire) {
		this.id_commentaire = id_commentaire;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public Plante getPlante() {
		return plante;
	}


	public void setPlante(Plante plante) {
		this.plante = plante;
	}


	@Override
	public String toString() {
		return "Commentaire [id_commentaire=" + id_commentaire + ", commentaire=" + commentaire + ", plante="
				+ plante + "]";
	}
	
}

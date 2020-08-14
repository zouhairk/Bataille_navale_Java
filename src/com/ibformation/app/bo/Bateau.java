package com.ibformation.app.bo;

public class Bateau {

	private int idBateau;
	private int idJoueur;
	private int taille;

	public Bateau() {
		
	}

	public Bateau(int idBateau) {
		this.idBateau = idBateau;
	}
	
	public Bateau(int idBateau, int idJoueur, int taille) {
		this.idBateau = idBateau;
		this.idJoueur = idJoueur;
		this.taille = taille;
	}

	public int getIdBateau() {
		return idBateau;
	}

	public void setIdBateau(int idBateau) {
		this.idBateau = idBateau;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	@Override
	public String toString() {
		return "Bateau [idBateau=" + idBateau + ", idJoueur=" + idJoueur + ", taille=" + taille + "]";
	}

}

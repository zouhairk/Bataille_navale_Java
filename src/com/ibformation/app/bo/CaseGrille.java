package com.ibformation.app.bo;

public class CaseGrille {

	private int idCase;
	private int idJoueur;
	private int abscisse;
	private int ordonnee;
	private Bateau bateau;
	private ETAT etatCase;
	
	
	
	public CaseGrille(int idCase, int idJoueur, int abscisse, int ordonnee, Bateau bateau, ETAT etatCase) {
		super();
		this.idCase = idCase;
		this.idJoueur = idJoueur;
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.bateau = bateau;
		this.etatCase = etatCase;
	}
	
	public CaseGrille(int idJoueur, int abscisse, int ordonnee, Bateau bateau, ETAT etatCase) {
		super();
		this.idJoueur = idJoueur;
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
		this.bateau = bateau;
		this.etatCase = etatCase;
	}


	public CaseGrille() {
	}

 
	public int getIdCase() {
		return idCase;
	}

	public void setIdCase(int idCase) {
		this.idCase = idCase;
	}

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}

 
	public ETAT getEtatCase() {
		return etatCase;
	}

	public void setEtatCase(ETAT etatCase) {
		this.etatCase = etatCase;
	}


	public Bateau getBateau() {
		return bateau;
	}


	public void setBateau(Bateau bateau) {
		this.bateau = bateau;
	}


	@Override
	public String toString() {
		return "CaseGrille [idCase=" + idCase + ", idJoueur=" + idJoueur + ", abscisse=" + abscisse + ", ordonnee="
				+ ordonnee + ", bateau=" + bateau + ", etatCase=" + etatCase + "]";
	}

 

}

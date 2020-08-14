package com.ibformation.app.service;

import java.util.List;

import com.ibformation.app.bo.CaseGrille;

public interface CaseGrilleService {

	CaseGrille recupererCaseGrille(int idCaseGrilleArecuperer);

	List<CaseGrille> recupererCasesGrilleBateau(int idBateau);

	List<CaseGrille> recupererCasesGrilleJoueur(int idJoueur);

	void creerCaseGrille(CaseGrille caseGrille);

	void modifierCaseGrille(CaseGrille caseGrille);

	void supprimerCaseGrille(int idCaseGrilleASupprimer);

	void remplirNouvelleGrilleJoueur(Object[][] data);

	boolean attacker(int i, int j, Object[][] data);

	boolean verifierPartie(Object[][] data);

	public CaseGrille[][] remplirNouvelleGrilleOrdi(CaseGrille[][] data);

}

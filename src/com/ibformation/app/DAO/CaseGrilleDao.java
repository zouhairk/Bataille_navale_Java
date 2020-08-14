package com.ibformation.app.DAO;

import java.util.List;

import com.ibformation.app.bo.CaseGrille;

public interface CaseGrilleDao {
	
	CaseGrille recupererCaseGrille(int idCaseGrilleArecuperer);
	
	List<CaseGrille> recupererCasesGrilleBateau (int idBateau);
	
	List<CaseGrille> recupererCasesGrilleJoueur (int idJoueur);

	void creerCaseGrille(CaseGrille caseGrille);

	void modifierCaseGrille(CaseGrille caseGrille);

	void supprimerCaseGrille(int idCaseGrilleASupprimer);

}

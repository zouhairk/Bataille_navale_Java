package com.ibformation.app.service;

import java.util.List;

import com.ibformation.app.bo.Bateau;

public interface BateauService {
	
	Bateau recupererBateau(int idBateauArecuperer);
	
	List<Bateau> recupererBateaux();

	void creerBateau(Bateau bateau);

	void modifierBateau(Bateau bateau);

	void supprimerBateau(int idBateauASupprimer);

}

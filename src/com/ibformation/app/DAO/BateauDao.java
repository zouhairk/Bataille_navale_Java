package com.ibformation.app.DAO;

import java.util.List;

import com.ibformation.app.bo.Bateau;

public interface BateauDao {
	
	Bateau recupererBateau(int idBateauArecuperer);

	void creerBateau(Bateau bateau);

	void modifierBateau(Bateau bateau);

	void supprimerBateau(int idBateauASupprimer);

	List<Bateau> recupererBateaux();

}

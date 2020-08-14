package com.ibformation.app.service;

import java.util.List;

import com.ibformation.app.DAO.BateauDao;
import com.ibformation.app.DAO.BateauDaoImpl;
import com.ibformation.app.bo.Bateau;

public class BateauServiceImpl implements BateauService {
	
	BateauDao bateauDao = new BateauDaoImpl();

	@Override
	public Bateau recupererBateau(int idBateauArecuperer) {
		return bateauDao.recupererBateau(idBateauArecuperer);
	}

	@Override
	public void creerBateau(Bateau bateau) {
		bateauDao.creerBateau(bateau);
	}

	@Override
	public void modifierBateau(Bateau bateau) {
		bateauDao.modifierBateau(bateau);
	}

	@Override
	public void supprimerBateau(int idBateauASupprimer) {
		bateauDao.supprimerBateau(idBateauASupprimer);
	}

	@Override
	public List<Bateau> recupererBateaux() {
		return bateauDao.recupererBateaux();
	}

}

package com.ibformation.app.service;

import java.util.ArrayList;
import java.util.List;

import com.ibformation.app.DAO.CaseGrilleDao;
import com.ibformation.app.DAO.CaseGrilleDaoImpl;
import com.ibformation.app.bo.Bateau;
import com.ibformation.app.bo.CaseGrille;
import com.ibformation.app.bo.ETAT;

public class CaseGrilleServiceImpl implements CaseGrilleService {

	CaseGrilleDao caseGrilleDao = new CaseGrilleDaoImpl();
	CaseGrille[][] grilleJoueur = new CaseGrille[12][12];

	@Override
	public CaseGrille recupererCaseGrille(int idCaseGrilleArecuperer) {
		return caseGrilleDao.recupererCaseGrille(idCaseGrilleArecuperer);
	}

	@Override
	public List<CaseGrille> recupererCasesGrilleBateau(int idBateau) {
		return caseGrilleDao.recupererCasesGrilleBateau(idBateau);
	}

	@Override
	public List<CaseGrille> recupererCasesGrilleJoueur(int idJoueur) {
		return caseGrilleDao.recupererCasesGrilleJoueur(idJoueur);
	}

	@Override
	public void creerCaseGrille(CaseGrille caseGrille) {
		caseGrilleDao.creerCaseGrille(caseGrille);
	}

	@Override
	public void modifierCaseGrille(CaseGrille caseGrille) {
		caseGrilleDao.modifierCaseGrille(caseGrille);
	}

	@Override
	public void supprimerCaseGrille(int idCaseGrilleASupprimer) {
		caseGrilleDao.supprimerCaseGrille(idCaseGrilleASupprimer);
	}

	@Override
	public void remplirNouvelleGrilleJoueur(Object[][] data) {

		int abscisse = 0;
		int ordonnee = 0;
		int idJoueur = 0;

		for (CaseGrille[] horizontaleGrille : grilleJoueur) {
			for (CaseGrille caseGrille : horizontaleGrille) {

				caseGrille = new CaseGrille(idJoueur, abscisse, ordonnee, new Bateau(0), ETAT.VIDE);

				if (data[ordonnee][abscisse] != null) {
					caseGrille.setBateau(new Bateau(Integer.parseInt(String.valueOf(data[ordonnee][abscisse]))));
					caseGrille.setEtatCase(ETAT.PLEIN);
					System.out.println(caseGrille);
				}
				ordonnee++;
			}
			abscisse++;
			ordonnee = 0;
		}
	}

	@Override
	public boolean attacker(int i, int j, Object[][] data) {
		boolean result = false;
		for (int k = 0; k < 12; k++) {
			for (int l = 0; l < 12; l++) {
				if (k == i && l == j && ((CaseGrille) data[k][l]).getEtatCase() == ETAT.VIDE)
					((CaseGrille) data[k][l]).setEtatCase(ETAT.A_L_EAU);
				else if (k == i && l == j && ((CaseGrille) data[k][l]).getEtatCase() == ETAT.PLEIN) {
					((CaseGrille) data[k][l]).setEtatCase(ETAT.TOUCHE);
					result = true;

				} else {
					// DANS CE CAS TU JOUE UNE CASE TOUCHE OU A L EAU C EST TOUJOURS TON TOUR
				}
			}
		}
		return result;
	}

	@Override
	public boolean verifierPartie(Object[][] data) {
		int somme = 0;
		int pivot = 0;
		for (int k = 0; k < 12; k++) {
			for (int l = 0; l < 12; l++) {
				somme += ((CaseGrille) data[k][l]).getBateau().getTaille();
			}
		}

		for (int k = 0; k < 12; k++) {
			for (int l = 0; l < 12; l++) {
				if (((CaseGrille) data[k][l]).getEtatCase() == ETAT.TOUCHE) {
					pivot++;
				}

			}
		}

		return somme == pivot;
	}

	/*
	 * L’application, de type client lourd et réalisé en java, consiste en un jeu de
	 * bataille navale classique. Le joueur doit placer 5 bâtiments (2 cases, 3
	 * cases, 3 cases, 4 cases, 5 cases)
	 */
	@Override
	public CaseGrille[][] remplirNouvelleGrilleOrdi(CaseGrille[][] data) {
		Bateau b1 = new Bateau(1, 2, 2);
		Bateau b2 = new Bateau(2, 2, 3);
		Bateau b3 = new Bateau(3, 2, 3);
		Bateau b4 = new Bateau(4, 2, 4);
		Bateau b5 = new Bateau(5, 2, 5);

		List<Bateau> bateaux = new ArrayList<Bateau>();
		bateaux.add(b1);
		bateaux.add(b2);
		bateaux.add(b3);
		bateaux.add(b4);
		bateaux.add(b5);

		final int min = 0;
		final int max = 11;

		for (Bateau b : bateaux) {

			/*
			 * Horizontale 0 verticale 1
			 */
			int positionX = (int) (Math.random() * ((max - min) + 1)) + min;
			int positionY = (int) (Math.random() * ((max - min) + 1)) + min;

			/*
			 * Je l'ai positionner ici car je veux a chaque fois il change de position
			 * verticale ou Horizontale selon le bateau
			 */
			// int position = 1;
			int position = (int) (Math.random() * 10 > 5 ? 0 : 1);

			for (int i = 0; i < b.getTaille(); i++) {

				if (position == 0) {
					
						if (data[(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)][positionY]
								.getEtatCase() != ETAT.PLEIN) {
							data[(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)][positionY]
									.setEtatCase(ETAT.PLEIN);
							data[(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)][positionY]
									.setBateau(b);
							data[(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)][positionY]
									.setAbscisse(i);
							data[(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)][positionY]
									.setOrdonnee(positionY);
							data[(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)][positionY]
									.setBateau(b);
						} else {

							/*
							 * Si un bateau existe on decale
							 */

							data[(i + positionY) >= 12 ? (i + positionY + b.getTaille()) % 12
									: (i + positionY)][positionY].setEtatCase(ETAT.PLEIN);
							data[(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
									: (i + positionY + b.getTaille())][positionY].setBateau(b);
							data[(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
									: (i + positionY + b.getTaille())][positionY].setAbscisse(i);
							data[(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
									: (i + positionY + b.getTaille())][positionY].setOrdonnee(positionY);
							data[(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
									: (i + positionY + b.getTaille())][positionY].setBateau(b);
						}
					}else

					if (data[positionX][(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)]
							.getEtatCase() != ETAT.PLEIN) {
						data[positionX][(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)]
								.setEtatCase(ETAT.PLEIN);
						data[positionX][(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)]
								.setOrdonnee(positionX);
						data[positionX][(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)].setAbscisse(i);
						data[positionX][(i + positionY) >= 12 ? (i + positionY) % 12 : (i + positionY)].setBateau(b);
					} else {

						/*
						 * Si un bateau existe on decale
						 */

						data[positionX][(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
								: (i + positionY + b.getTaille())].setEtatCase(ETAT.PLEIN);
						data[positionX][(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
								: (i + positionY + b.getTaille())].setOrdonnee(positionX);
						data[positionX][(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
								: (i + positionY + b.getTaille())].setAbscisse(i);
						data[positionX][(i + positionY + b.getTaille()) >= 12 ? (i + positionY + b.getTaille()) % 12
								: (i + positionY + b.getTaille())].setBateau(b);
					}
				}

			}
		

		return data;
	}

 

}

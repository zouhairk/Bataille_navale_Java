package com.ibformation.app.main;

import java.util.List;
import java.util.Scanner;

import com.ibformation.app.bo.Bateau;
import com.ibformation.app.bo.CaseGrille;
import com.ibformation.app.bo.ETAT;
import com.ibformation.app.service.BateauService;
import com.ibformation.app.service.BateauServiceImpl;
import com.ibformation.app.service.CaseGrilleService;
import com.ibformation.app.service.CaseGrilleServiceImpl;

public class testBDD {

	private static BateauService bateauService = new BateauServiceImpl();
	private static CaseGrilleService caseGrilleService = new CaseGrilleServiceImpl();
	
	public static void main(String[] args) {

		do {
				
			
			System.out.println("\t*****  Test interaction BDD  *****");
			System.out.println("1 - creation de bateaux");
			System.out.println("2 - affichage des bateaux");
			System.out.println("3 - affichage bateau id 1");
			System.out.println("4 - modifier bateaux taille+1 ");
			System.out.println("5 - suppression de id 3");
			System.out.println("\n6 - creation de cases");
			System.out.println("7 - affichage des cases du joueur 1");
			System.out.println("8 - affichage case id 2");
			System.out.println("9 - affichage cases bateau 4");
			System.out.println("10 - modifier case id 2 etat : -> VIDE ");
			System.out.println("11 - suppression de id 1");
			
			Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()) {
			case 1:
				bateauService.creerBateau(new Bateau(0, 1, 3));
				bateauService.creerBateau(new Bateau(0, 1, 2));
				bateauService.creerBateau(new Bateau(0, 2, 5));
				bateauService.creerBateau(new Bateau(0, 2, 4)); 
				bateauService.creerBateau(new Bateau(0, 1, 1));
				bateauService.creerBateau(new Bateau(0, 2, 2));
				bateauService.creerBateau(new Bateau(0, 3, 3));
				break;
	
			case 2:
				System.out.println(bateauService.recupererBateaux());
				break;
			case 3:
				System.out.println(bateauService.recupererBateau(1));
				break;
			case 4:
				List<Bateau> bateaux = bateauService.recupererBateaux();
				for (Bateau bateau : bateaux) {
					bateau.setTaille(bateau.getTaille() + 1);
					bateauService.modifierBateau(bateau);
				}
				break;
			case 5:
				bateauService.supprimerBateau(3);
				break;
			case 6:
				/*caseGrilleService.creerCaseGrille(new CaseGrille(0, 11, 44, 1, ETAT.VIDE));
				caseGrilleService.creerCaseGrille(new CaseGrille(1, 742, 12, 1, ETAT.PLEIN));
				caseGrilleService.creerCaseGrille(new CaseGrille(1, 45, 44, 4, ETAT.TOUCHE));
				caseGrilleService.creerCaseGrille(new CaseGrille(2, 85, 110, 2, ETAT.VIDE));
				caseGrilleService.creerCaseGrille(new CaseGrille(0, 85, 110, 4, ETAT.VIDE));
				caseGrilleService.creerCaseGrille(new CaseGrille(1, 60, 50, 4, ETAT.PLEIN));*/
				break;
			case 7:
				List<CaseGrille> cases = caseGrilleService.recupererCasesGrilleJoueur(1);
				for (CaseGrille case1 : cases) {
					System.out.println(case1);
				}
				break;
			case 8:
				System.out.println(caseGrilleService.recupererCaseGrille(2));
				break;	
			case 9:
				List<CaseGrille> cases2 = caseGrilleService.recupererCasesGrilleBateau(4);
				for (CaseGrille case1 : cases2) {
					System.out.println(case1);
				}
				break;
			case 10:
				//CaseGrille case2 = new CaseGrille(2, 12, 22, 4, ETAT.VIDE);
				//case2.setIdCase(2);
				//caseGrilleService.modifierCaseGrille(case2);
				break;
			case 11:
				caseGrilleService.supprimerCaseGrille(1);
				break;
				
			default:
				break;
			}
			
		} while (true);

	}

}

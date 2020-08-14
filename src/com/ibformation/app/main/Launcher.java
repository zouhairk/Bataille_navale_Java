package com.ibformation.app.main;

import java.awt.EventQueue;

import com.ibformation.app.bo.CaseGrille;
import com.ibformation.app.service.CaseGrilleService;
import com.ibformation.app.service.CaseGrilleServiceImpl;
import com.ibformation.app.vues.Accueil;

public class Launcher {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
 
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 * L'index
					 */
					Accueil frame = new Accueil();
					
					

					frame.setVisible(true);
			
					/*
					 * Un message pour montrer la fin de la partie ou si il y'a une erreure dans le
					 * programme
					 */
					/* Message dialog = new Message();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);*/

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

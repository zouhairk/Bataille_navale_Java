package com.ibformation.app.vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import com.ibformation.app.bo.Bateau;
import com.ibformation.app.bo.CaseGrille;
import com.ibformation.app.service.CaseGrilleService;
import com.ibformation.app.service.CaseGrilleServiceImpl;

public class PositionnerBateaux extends JFrame {

	
	private List<Bateau> listeBateauJoueur = new ArrayList<Bateau>();
	private Bateau bateauJoueur1 = new Bateau(1, 0, 2);
	private Bateau bateauJoueur2 = new Bateau(2, 0, 2);
	private Bateau bateauJoueur3 = new Bateau(3, 0, 3);
	private Bateau bateauJoueur4 = new Bateau(4, 0, 4);
	private Bateau bateauJoueur5 = new Bateau(5, 0, 5);
	private Object[][] data = new Object[12][12];
	private JPanel leftPanel = new JPanel();
	int indexListeBateau = 0;

	CaseGrilleService caseGrilleService = new CaseGrilleServiceImpl();

	private static final long serialVersionUID = -3192056304457199003L;

	public PositionnerBateaux() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);

		JPanel mainPanel = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		mainPanel.setLayout(borderLayout);

		JPanel north = new JPanel();
		GridLayout northLayout = new GridLayout(2, 1);
		north.setLayout(northLayout);
		JTextField titre = new JTextField("Placez vos bateaux");
		titre.setFont(new Font("Bauhaus 93", Font.BOLD, 40));
		JButton aleatoire = new JButton("Générer aléatoirement le placement");
		aleatoire.setLayout(null);
		aleatoire.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		aleatoire.addActionListener(new AleatoireClick());
		north.add(titre);
		north.add(aleatoire);
		mainPanel.add(north, BorderLayout.NORTH);

		JButton commencer = new JButton("Commencer");
		commencer.setLayout(null);
		commencer.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		mainPanel.add(commencer, BorderLayout.SOUTH);
		commencer.addActionListener(new CommencerClick());

		JPanel contentPanel = new JPanel();
		GridLayout contentLayout = new GridLayout(1, 2);
		contentPanel.setLayout(contentLayout);
		mainPanel.add(contentPanel, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(12, 12);
		leftPanel.setLayout(gridLayout);
		Border blackline = BorderFactory.createLineBorder(Color.BLACK, 1);
		listeBateauJoueur.add(bateauJoueur1);
		listeBateauJoueur.add(bateauJoueur2);
		listeBateauJoueur.add(bateauJoueur3);
		listeBateauJoueur.add(bateauJoueur4);
		listeBateauJoueur.add(bateauJoueur5);

		
		int abscisse = 0;
		int ordonnee = 0;
		for (Object[] objoctHorizon : data) {
			for (Object object : objoctHorizon) {
				JPanel caseGrille = new JPanel();
				caseGrille.setBorder(blackline);
				leftPanel.add(caseGrille);
				caseGrille.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
					}
					@Override
					public void mousePressed(MouseEvent e) {
					}
					@Override
					public void mouseExited(MouseEvent e) {
					}
					@Override
					public void mouseEntered(MouseEvent e) {
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						System.out.println(indexListeBateau);
						if (indexListeBateau < listeBateauJoueur.size()) {
							caseGrille.setBackground(Color.BLACK);
							// Placer le bateau à l'horizontal vers l'Est
							if (data[abscisse][ordonnee] == null) {

								int j = 1;
								for (int i = 0; i < listeBateauJoueur.get(indexListeBateau).getTaille(); i++) {
									if (ordonnee + i < 12) {
										data[abscisse][ordonnee + i] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
									} else {
										data[abscisse][ordonnee - j] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
										j++;
									}
								}
								
							} 
							// Placer le bateau à l'horizontal vers le Sud
							else {
								int j = 1;
								for (int i = 0; i < listeBateauJoueur.get(indexListeBateau).getTaille(); i++) {
									if (ordonnee + i < 12) {
										data[abscisse + i][ordonnee] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
									} else {
										data[abscisse - j][ordonnee] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
										j++;
									}
								}
							}
							indexListeBateau++;
						}
					}
				});
			}
		}
	
		contentPanel.add(leftPanel);

		JPanel rightPanel = new JPanel();
		BorderLayout borderLayoutRight = new BorderLayout();
		rightPanel.setLayout(borderLayoutRight);
		contentPanel.add(rightPanel);

		JPanel titleRight = new JPanel();
		titleRight.add(new JTextField("Bateaux"));
		rightPanel.add(titleRight, BorderLayout.NORTH);

		JPanel bateauxPanel = new JPanel();
		GridBagLayout grilleBateau = new GridBagLayout();

		bateauxPanel.setLayout(grilleBateau);
		bateauxPanel.setBackground(Color.WHITE);
		rightPanel.add(bateauxPanel, BorderLayout.CENTER);

		JTextPane bateau1 = new JTextPane();
		// bateau1.setBackground(Color.RED);
		bateau1.setPreferredSize(new Dimension(70, 10));
		rightPanel.add(bateau1);

		JTextPane bateau2 = new JTextPane();
		// bateau2.setBackground(Color.BLUE);
		bateau2.setPreferredSize(new Dimension(70, 10));
		rightPanel.add(bateau2);

		this.setContentPane(mainPanel);

	}

	public class AleatoireClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println(leftPanel.getComponentCount());
            CaseGrille[][] grilleAleatoire = new CaseGrille[12][12];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    grilleAleatoire[i][j] = new CaseGrille();
                }
            }
            grilleAleatoire = caseGrilleService.remplirNouvelleGrilleOrdi(grilleAleatoire);

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    System.out.println(grilleAleatoire[i][j]);
                }
            }

            System.out.println(leftPanel.getComponentCount());
            leftPanel.revalidate();
            leftPanel.repaint();
            
            System.out.println(leftPanel.getComponentCount());

            Border blackline = BorderFactory.createLineBorder(Color.BLACK,2);
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    JPanel caseGrille = leftPanel;
                    //caseGrille.setBorder(blackline);
                  //  leftPanel.add(caseGrille);
                    if (grilleAleatoire[i][j].getBateau() != null) {
                        caseGrille.setBackground(Color.RED);
                        leftPanel.add(caseGrille);
                    }
                }
            }
            leftPanel.setVisible(true);
            
            System.out.println(leftPanel.getComponentCount());
            //contentPanel.repaint();
            //leftPanel.revalidate();
            setVisible(true);
        }

    }
	public class CommencerClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CaseGrilleService caseGrilleService = new CaseGrilleServiceImpl();
			caseGrilleService.remplirNouvelleGrilleJoueur(data);
			Jeux frameJeux = new Jeux();
			frameJeux.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frameJeux.setUndecorated(true);

			frameJeux.setVisible(true);
		}

	}


}

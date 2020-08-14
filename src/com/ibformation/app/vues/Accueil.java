package com.ibformation.app.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Accueil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2364386013748387788L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public Accueil() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		JLabel titre = new JLabel("     Bataille Navale");
		titre.setFont(new Font("Bauhaus 93", Font.BOLD, 40));
		titre.setForeground(new Color(98, 136, 206));
		titre.setBounds(30, 50, 440, 120);
		Border border = BorderFactory.createLineBorder(new Color(50, 88, 158), 4);
		titre.setBorder(border);
		contentPane.add(titre);

		AbstractButton boutonNouvellePartie = new JButton("Nouvelle partie");
		boutonNouvellePartie.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		boutonNouvellePartie.setBounds(90, 220, 320, 80);
		boutonNouvellePartie.setBackground(new Color(230, 230, 230));
		boutonNouvellePartie.setFocusable(false);
		Border borderBouton = BorderFactory.createLineBorder(new Color(50, 88, 158), 5, true);
		boutonNouvellePartie.setBorder(borderBouton);
		boutonNouvellePartie.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				boutonNouvellePartie.setBackground(new Color(230, 230, 230));
				boutonNouvellePartie.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				boutonNouvellePartie.setBackground(new Color(134, 163, 217));
				boutonNouvellePartie.setForeground(new Color(250, 250, 250));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		boutonNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PositionnerBateaux positionnerBateaux = new PositionnerBateaux();
				contentPane.setVisible(false);
			}
		});
		contentPane.add(boutonNouvellePartie);

		
		JButton boutonChargerPartie = new JButton("Charger partie");
		boutonChargerPartie.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		boutonChargerPartie.setBounds(90, 320, 320, 80);
		boutonChargerPartie.setBackground(new Color(230, 230, 230));
		boutonChargerPartie.setFocusable(false);
		boutonChargerPartie.setBorder(borderBouton);
		boutonChargerPartie.setToolTipText("Charger la partie pr\u00E9c\u00E9dente ");
		boutonChargerPartie.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				boutonChargerPartie.setBackground(new Color(230, 230, 230));
				boutonChargerPartie.setForeground(new Color(0, 0, 0));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				boutonChargerPartie.setBackground(new Color(134, 163, 217));
				boutonChargerPartie.setForeground(new Color(250, 250, 250));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		boutonChargerPartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Le Jeux
				 */
				Jeux frameJeux = new Jeux();
				frameJeux.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frameJeux.setUndecorated(true);

				frameJeux.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		contentPane.add(boutonChargerPartie);
	}

}
 

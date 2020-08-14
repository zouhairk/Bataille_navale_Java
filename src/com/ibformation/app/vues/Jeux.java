package com.ibformation.app.vues;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.ibformation.app.bo.Bateau;
import com.ibformation.app.bo.CaseGrille;
import com.ibformation.app.service.CaseGrilleService;
import com.ibformation.app.service.CaseGrilleServiceImpl;
import com.ibformation.app.service.StatusColumnCellRenderer;

public class Jeux extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -139935818785514917L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private int indexListeBateau;
	private List<Bateau> listeBateauJoueur = new ArrayList<Bateau>();
	private Bateau bateauJoueur1 = new Bateau(1, 0, 2);
	private Bateau bateauJoueur2 = new Bateau(2, 0, 2);
	private Bateau bateauJoueur3 = new Bateau(3, 0, 3);
	private Bateau bateauJoueur4 = new Bateau(4, 0, 4);
	private Bateau bateauJoueur5 = new Bateau(5, 0, 5);
	CaseGrille[][] grilleOrdi = new CaseGrille[12][12];
	int idOrdi = 1;
	private Object[][] data = new Object[12][12];

	/**
	 * Create the frame.
	 */
	public Jeux() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnNewButton = new JButton("Sauvegarder la partie");

		btnNewButton.setIcon(
				new ImageIcon(System.getProperty("user.dir") + "\\src\\com\\ibformation\\app\\resources\\save.PNG"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Message message = new Message("La partie est sauvegardée");
				message.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Charger partie");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setIcon(
				new ImageIcon(System.getProperty("user.dir") + "\\src\\com\\ibformation\\app\\resources\\history.png"));
		btnNewButton_1.setToolTipText("Charger la partie pr\\u00E9c\\u00E9dente ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Quitter la partie");
		btnNewButton_2.setIcon(
				new ImageIcon(System.getProperty("user.dir") + "\\src\\com\\ibformation\\app\\resources\\exit.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);

		listeBateauJoueur.add(bateauJoueur1);
		listeBateauJoueur.add(bateauJoueur2);
		listeBateauJoueur.add(bateauJoueur3);
		listeBateauJoueur.add(bateauJoueur4);
		listeBateauJoueur.add(bateauJoueur5);

		creationJTableJoueur();
		ajouterBateauAJTabbleJoueur();
		panel.add(table);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		String[] columnNames2 = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
		Object[][] data2 = { { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" },
				{ "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" }

		};

		DefaultTableModel model2 = new DefaultTableModel(data2, columnNames2);
		table_1 = new JTable(model2);
		/*
		 * Pour le test
		 */
		table_1.getColumnModel().getColumn(0).setCellRenderer(new StatusColumnCellRenderer(Color.blue));

		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();

				Message message = new Message("T'as cliqué sur " + row + " et la colone" + col);
				message.setVisible(true);

			}
		});
		panel_1.add(table_1);
		// stamp
		JButton btnNewButton_3 = new JButton("Valider les emplacements");
		btnNewButton_3.setIcon(
				new ImageIcon(System.getProperty("user.dir") + "\\src\\com\\ibformation\\app\\resources\\stamp.png"));
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 28));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 3;
		btnNewButton_3.addActionListener(new ValiderEmplacementsListener());
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);

		JList list = new JList();

		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 2;
		gbc_list.gridy = 4;
		contentPane.add(list, gbc_list);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 7;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
	}

	private void ajouterBateauAJTabbleJoueur() {
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				DefaultTableCellRenderer statusColumn = new StatusColumnCellRenderer(Color.BLACK);
				statusColumn.getTableCellRendererComponent(table, data, false, false, row, col);

				if (indexListeBateau < listeBateauJoueur.size()) {
					Message message = new Message("T'as cliqué sur " + row + " et la colone " + col);
					message.setVisible(true);
					// Placer le bateau à l'horizontal vers l'Est
					if (data[row][col] == null) {

						int j = 1;
						for (int i = 0; i < listeBateauJoueur.get(indexListeBateau).getTaille(); i++) {
							if (col + i < 12) {
								data[row][col + i] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
							} else {
								data[row][col - j] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
								j++;
							}
						}
						indexListeBateau++;
					}
					// Placer le bateau à l'horizontal vers le Sud
					else {
						int j = 1;
						for (int i = 0; i < listeBateauJoueur.get(indexListeBateau).getTaille(); i++) {
							if (col + i < 12) {
								data[row + i][col] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
							} else {
								data[row - j][col] = listeBateauJoueur.get(indexListeBateau).getIdBateau();
								j++;
							}
						}
					}
				}
			}
		});
	}

	private void creationJTableJoueur() {
		String[] columnNames = new String[12];
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);

	}

	public class ValiderEmplacementsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			CaseGrilleService caseGrilleService = new CaseGrilleServiceImpl();
			caseGrilleService.remplirNouvelleGrilleJoueur(data);

		}
	}

}

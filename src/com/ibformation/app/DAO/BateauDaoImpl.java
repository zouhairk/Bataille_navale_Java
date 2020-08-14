package com.ibformation.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibformation.app.bo.Bateau;
import com.ibformation.app.bo.CaseGrille;

public class BateauDaoImpl implements BateauDao {
	
	private CaseGrilleDao caseDao = new CaseGrilleDaoImpl();

	@Override
	public Bateau recupererBateau(int idBateauArecuperer) {
		Connection cnx = DAOUtil.getConnexion();
		Bateau bateau = new Bateau();
		try {
			String requete = "SELECT * From Bateau WHERE id_bateau = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, idBateauArecuperer);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bateau.setIdBateau(rs.getInt("id_bateau"));
				bateau.setIdJoueur(rs.getInt("id_joueur"));
				bateau.setTaille(rs.getInt("taille"));
			}
			cnx.close();
		} catch (Exception e) {
		}
		return bateau;
	}

	@Override
	public void creerBateau(Bateau bateau) {
		Connection cnx = DAOUtil.getConnexion();
		try {
			String requete = "INSERT INTO Bateau (id_joueur, taille) VALUES (?,?)";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, bateau.getIdJoueur());
			pstmt.setInt(2, bateau.getTaille());
			pstmt.executeUpdate();
			cnx.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void modifierBateau(Bateau bateau) {
		Connection cnx = DAOUtil.getConnexion();
		try {
			String requete = "UPDATE Bateau SET id_joueur = ?, taille  = ? WHERE id_bateau = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, bateau.getIdJoueur());
			pstmt.setInt(2, bateau.getTaille());
			pstmt.setInt(3, bateau.getIdBateau());
			pstmt.executeUpdate();
			cnx.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void supprimerBateau(int idBateauASupprimer) {
		
		// suppression cases avant suppression bateau
		List<CaseGrille> casesGrille = caseDao.recupererCasesGrilleBateau(idBateauASupprimer);
		for (CaseGrille caseGrille : casesGrille) {
			caseDao.supprimerCaseGrille(caseGrille.getIdCase());
		}
		
		Connection cnx = DAOUtil.getConnexion();
		String requete = "DELETE FROM Bateau WHERE id_bateau = ?";
		try {
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, idBateauASupprimer);
			pstmt.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Bateau> recupererBateaux() {
		Connection cnx = DAOUtil.getConnexion();
		List<Bateau> bateaux = new ArrayList<Bateau>();
		try {
			String requete = "SELECT * From Bateau";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Bateau bateau = new Bateau();
				bateau.setIdBateau(rs.getInt("id_bateau"));
				bateau.setIdJoueur(rs.getInt("id_joueur"));
				bateau.setTaille(rs.getInt("taille"));
				bateaux.add(bateau);
			}
			cnx.close();
		} catch (Exception e) {
		}
		return bateaux;
	}

}

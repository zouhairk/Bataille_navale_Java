package com.ibformation.app.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibformation.app.bo.CaseGrille;
import com.ibformation.app.bo.ETAT;

public class CaseGrilleDaoImpl implements CaseGrilleDao {
	
	@Override
	public CaseGrille recupererCaseGrille(int idCaseGrilleArecuperer) {
		Connection cnx = DAOUtil.getConnexion();
		CaseGrille caseGrille = new CaseGrille();
		try {
			String requete = "SELECT * From CaseGrille WHERE id_case = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, idCaseGrilleArecuperer);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				caseGrille.setIdCase(rs.getInt("id_case"));
				caseGrille.setIdJoueur(rs.getInt("id_joueur"));
				caseGrille.setAbscisse(rs.getInt("abscisse"));
				caseGrille.setOrdonnee(rs.getInt("ordonnee"));
				//caseGrille.setIdBateau(rs.getInt("id_bateau"));
				caseGrille.setEtatCase(ETAT.valueOf(rs.getString("etat_case")));
			}
			cnx.close();
		} catch (Exception e) {
		}
		return caseGrille;
	}

	@Override
	public void creerCaseGrille(CaseGrille caseGrille) {
		Connection cnx = DAOUtil.getConnexion();
		try {
			String requete = "INSERT INTO CaseGrille (id_joueur, abscisse, ordonnee, id_bateau, etat_case) VALUES (?,?,?,?,?)";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, caseGrille.getIdJoueur());
			pstmt.setInt(2, caseGrille.getAbscisse());
			pstmt.setInt(3, caseGrille.getOrdonnee());
			//pstmt.setInt(4, caseGrille.getIdBateau());
			pstmt.setString(5, caseGrille.getEtatCase().toString());
			pstmt.executeUpdate();
			cnx.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void modifierCaseGrille(CaseGrille caseGrille) {
		Connection cnx = DAOUtil.getConnexion();
		try {
			String requete = "UPDATE CaseGrille SET id_joueur = ?, abscisse = ?, ordonnee = ?, id_bateau = ?, etat_case = ? WHERE id_case = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, caseGrille.getIdJoueur());
			pstmt.setInt(2, caseGrille.getAbscisse());
			pstmt.setInt(3, caseGrille.getOrdonnee());
			//pstmt.setInt(4, caseGrille.getIdBateau());
			pstmt.setString(5, caseGrille.getEtatCase().toString());
			pstmt.setInt(6, caseGrille.getIdCase());
			pstmt.executeUpdate();
			cnx.close();
		} catch (Exception e) {
		}
	}

	@Override
	public void supprimerCaseGrille(int idCaseGrilleASupprimer) {
				Connection cnx = DAOUtil.getConnexion();
		String requete = "DELETE FROM CaseGrille WHERE id_case = ?";
		try {
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, idCaseGrilleASupprimer);
			pstmt.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CaseGrille> recupererCasesGrilleBateau(int idBateau) {
		List<CaseGrille> casesGrille = new ArrayList<CaseGrille>();
		Connection cnx = DAOUtil.getConnexion();
		try {
			String requete = "SELECT * From CaseGrille WHERE id_bateau = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, idBateau);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CaseGrille caseGrille = new CaseGrille();
				caseGrille.setIdCase(rs.getInt("id_case"));
				caseGrille.setIdJoueur(rs.getInt("id_joueur"));
				caseGrille.setAbscisse(rs.getInt("abscisse"));
				caseGrille.setOrdonnee(rs.getInt("ordonnee"));
				//caseGrille.setIdBateau(rs.getInt("id_bateau"));
				caseGrille.setEtatCase(ETAT.valueOf(rs.getString("etat_case")));
				casesGrille.add(caseGrille);
			}
			cnx.close();
		} catch (Exception e) {
		}
		return casesGrille;
	}

	@Override
	public List<CaseGrille> recupererCasesGrilleJoueur(int idJoueur) {
		List<CaseGrille> casesGrille = new ArrayList<CaseGrille>();
		Connection cnx = DAOUtil.getConnexion();
		try {
			String requete = "SELECT * From CaseGrille WHERE id_joueur = ?";
			PreparedStatement pstmt = cnx.prepareStatement(requete);
			pstmt.setInt(1, idJoueur);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CaseGrille caseGrille = new CaseGrille();
				caseGrille.setIdCase(rs.getInt("id_case"));
				caseGrille.setIdJoueur(rs.getInt("id_joueur"));
				caseGrille.setAbscisse(rs.getInt("abscisse"));
				caseGrille.setOrdonnee(rs.getInt("ordonnee"));
				//caseGrille.setIdBateau(rs.getInt("id_bateau"));
				caseGrille.setEtatCase(ETAT.valueOf(rs.getString("etat_case")));
				casesGrille.add(caseGrille);
			}
			cnx.close();
		} catch (Exception e) {
		}
		return casesGrille;
	}

}

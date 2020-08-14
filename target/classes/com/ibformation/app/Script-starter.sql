CREATE DATABASE IF NOT EXISTS BDD_bataille_navale; USE
    BDD_bataille_navale;
    
CREATE TABLE IF NOT EXISTS CaseGrille(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_joueur INT NOT NULL,
    abscisse INT NOT NULL,
    ordonnee INT NOT NULL,
    id_bateau INT,
    etat_case VARCHAR(50) NOT NULL
);
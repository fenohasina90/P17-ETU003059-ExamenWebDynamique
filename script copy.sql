drop DATABASE examen_servlet;
CREATE DATABASE IF NOT EXISTS examen_servlet;

USE examen_servlet;

CREATE TABLE prevision (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(50) NOT NULL ,
    montatnt INT NOT NULL
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE depense (
    id INT AUTO_INCREMENT PRIMARY KEY,
    libelle INT NOT NULL ,
    montatnt INT NOT NULL,
    FOREIGN KEY (libelle) REFERENCES prevision(id)
);

CREATE TABLE etat (
    id INT AUTO_INCREMENT PRIMARY KEY,
    prevision INT NOT NULL,
    depense INT NOT NULL,
    reste INT NOT NULL,
    FOREIGN KEY (prevision) REFERENCES prevision(id)
);



-- Insertion dans la table prevision
INSERT INTO prevision (libelle, montatnt) VALUES 
('Nourriture', 5000),
('Transport', 3000),
('Loisirs', 2000),
('Éducation', 10000),
('Santé', 4000);

-- Insertion dans la table depense
INSERT INTO depense (libelle, montatnt) VALUES 
(1, 1200), -- Dépense pour Nourriture
(1, 800),  -- Autre dépense pour Nourriture
(2, 500),  -- Dépense pour Transport
(2, 700),  -- Autre dépense pour Transport
(3, 300),  -- Dépense pour Loisirs
(4, 4500), -- Dépense pour Éducation
(5, 1200); -- Dépense pour Santé

-- Insertion dans la table etat (calculé automatiquement normalement)
INSERT INTO etat (prevision, depense, reste) VALUES 
(1, 2000, 3000),  -- Nourriture: 5000 - 2000 = 3000
(2, 1200, 1800),  -- Transport: 3000 - 1200 = 1800
(3, 300, 1700),   -- Loisirs: 2000 - 300 = 1700
(4, 4500, 5500),  -- Éducation: 10000 - 4500 = 5500
(5, 1200, 2800);  -- Santé: 4000 - 1200 = 2800

-- Insérer un utilisateur de test
INSERT INTO users (username, password) VALUES ('toto', 'admin12');
INSERT INTO users (username, password) VALUES ('admin', '1234');

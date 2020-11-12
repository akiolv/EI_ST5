CREATE DATABASE  IF NOT EXISTS `BDD`
USE `BDD`;

DROP TABLE IF EXISTS 'medecin_patient' cascade;
DROP TABLE IF EXISTS 'proches_patient' cascade;
DROP TABLE IF EXISTS 'Patient' cascade;
DROP TABLE IF EXISTS 'Proches' cascade;
DROP TABLE IF EXISTS 'Medecin' cascade;
DROP TABLE IF EXISTS 'Mesures' cascade;



CREATE TABLE `Patient` (
  `id_patient` SERIAL PRIMARY KEY,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `mot de passe` varchar(100) NOT NULL,
  `email` varchar(350) NOT NULL,
  'tel' varchar(100) NOT NULL,
  'adresse' varchar(350) NOT NULL

  );

CREATE TABLE `Mesures` (
  `id_mesure` SERIAL PRIMARY KEY,
  `date_prise` DATETIME NOT NULL,
  `niveau_glycemine`  FLOAT NOT NULL,
  `id_patient` BIGINT unsigned NOT NULL,
  FOREIGN KEY (id_patient) REFERENCES Patient(id_patient) ON DELETE cascade
  )


CREATE TABLE `Medecin` (
  `id_medecin` SERIAL PRIMARY KEY,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `adresse` varchar(350) NOT NULL,
  `email` varchar(350) NOT NULL,
  'tel' varchar(100) NOT NULL
  );


CREATE TABLE `Proches` (
  `id_proches` SERIAL PRIMARY KEY,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `lien` varchar(100) NOT NULL,
  `email` varchar(350) NOT NULL,
  'tel' varchar(100) NOT NULL
  );

CREATE TABLE 'proche_patient' (
  `id_proches` INTEGER,
  `id_patient` INTEGER,
  FOREIGN KEY (id_patient) REFERENCES Patient(id_patient) ON DELETE cascade,
  FOREIGN KEY (id_proches) REFERENCES Proches(id_proches) ON DELETE cascade
)

CREATE TABLE 'medecin_patient' (
  `id_medecin` INTEGER,
  `id_patient` INTEGER,
  FOREIGN KEY (id_patient) REFERENCES Patient(id_patient) ON DELETE cascade, 
  FOREIGN KEY (id_medecin) REFERENCES Medecin(id_medecin) ON DELETE cascade
)





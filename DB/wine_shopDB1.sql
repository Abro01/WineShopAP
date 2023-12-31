DROP DATABASE IF EXISTS wine_shop;
CREATE DATABASE wine_shop;
USE wine_shop;

CREATE TABLE amministratori(
    CF varchar(17) PRIMARY KEY NOT NULL,
    Nome varchar(10),
    Cognome varchar(10),
    Username varchar(10),
    Password varchar(10),
    Email varchar(20),
    Telefono varchar(10),
    IndResidenza varchar(30)
);

CREATE TABLE produttori(
    CF varchar(17) PRIMARY KEY NOT NULL,
    Nome varchar(10),
    Cognome varchar(10),
    Email varchar(20),
    Telefono varchar(10),
    IndAzienda varchar(30),
    Ruolo ENUM("Fornitore", "Corriere")
);

CREATE TABLE impiegati(
    CF varchar(17) PRIMARY KEY NOT NULL,
    Nome varchar(10),
    Cognome varchar(10),
    Username varchar(10),
    Password varchar(10),
    Email varchar(20),
    Telefono varchar(10),
    IndResidenza varchar(30),
    CODAmministratore varchar(17),
    FOREIGN KEY(CODAmministratore) REFERENCES amministratori(CF)
);

CREATE TABLE vini(
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nome varchar(20),
    Provenienza varchar(20),
    Anno int, 
    Descrizione varchar(255),
    Vitigno varchar(20),
    Prezzo double,
    Soglia int,
    Quantita int,
    Immagine varchar(100),
    CODProduttore varchar(17),
    FOREIGN KEY(CODProduttore) REFERENCES produttori(CF)
);    
    
CREATE TABLE offerte(
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    Descrizione varchar(255),
    Sconto int,
    CODVino int,
    FOREIGN KEY(CODVino) REFERENCES vini(ID)
);

CREATE TABLE utenti(
	CF varchar(17) PRIMARY KEY NOT NULL,
    Nome varchar(10),
    Cognome varchar(10),
    Username varchar(10),
    Password varchar(10),
    Email varchar(20),
    Telefono varchar(10),
    IndConsegna varchar(30),
    Online tinyInt(1),
    LastLogin DATETIME
);

CREATE TABLE ordini(
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    Totale double, 
    MetodoPagamento ENUM("Carta di credito", "Bonifico"),
    CODUtente varchar(17),
    FOREIGN KEY(CODUtente) REFERENCES utenti(CF)
);

CREATE TABLE dettagli_ordini(
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    Quantita int,
    CODOrdine int,
    CODVino int,
    FOREIGN KEY(CODOrdine) REFERENCES ordini(ID),
    FOREIGN KEY(CODVino) REFERENCES vini(ID)
);

CREATE TABLE recensioni(
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    Voto ENUM("1", "2" , "3" , "4", "5"),
    commento varchar(100),
    CODVino int,
    CODUtente varchar(17),
    FOREIGN KEY(CODVino) REFERENCES vini(ID),
    FOREIGN KEY(CODUtente) REFERENCES utenti(CF)
);

CREATE TABLE preferiti(
    ID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    CODVino int,
    CODUtente varchar(17),
    FOREIGN KEY(CODVino) REFERENCES vini(ID),
    FOREIGN KEY(CODUtente) REFERENCES utenti(CF)
);
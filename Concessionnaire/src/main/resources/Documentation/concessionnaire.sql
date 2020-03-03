CREATE DATABASE


CREATE TABLE villes(
id SERIAL,
name VARCHAR(100),
PRIMARY KEY (id)
);

CREATE TABLE magasins(
id SERIAL,
name VARCHAR(100),
ville INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (ville) REFERENCES villes(id)
);


CREATE TABLE prestations(
id SERIAL,
label VARCHAR(100),
tarif NUMERIC(10),
PRIMARY KEY (id)
);

CREATE TABLE voitures(
id SERIAL,
modele VARCHAR(100),
prix NUMERIC(100),
reserve BOOLEAN,
nb_places INTEGER,
magasin INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (magasin) REFERENCES magasins(id)
);

CREATE TABLE motos(
id SERIAL,
modele VARCHAR(100),
prix NUMERIC(100),
reserve BOOLEAN,
cylindree INTEGER,
magasin INTEGER,
PRIMARY KEY (id),
FOREIGN KEY (magasin) REFERENCES magasins(id)
);

// table de jointure

CREATE TABLE join_mag_pres (
magasin_id INTEGER,
prestation_id INTEGER,
PRIMARY KEY (magasin_id, prestation_id),
FOREIGN KEY (magasin_id) REFERENCES magasins(id),
FOREIGN KEY (prestation_id) REFERENCES prestations(id)
);

CREATE TABLE magasins_proches(
magasin_id INTEGER,
magasin_proche_id INTEGER,
PRIMARY KEY (magasin_id, magasin_proche_id),
FOREIGN KEY (magasin_id) REFERENCES magasins(id),
FOREIGN KEY (magasin_proche_id) REFERENCES magasins(id)
);


INSERT INTO villes (name) VALUES ('Montpellier');
INSERT INTO villes (name) VALUES ('Perols');
INSERT INTO villes (name) VALUES ('Sete');
INSERT INTO villes (name) VALUES ('Toulouse');

INSERT INTO magasins (name, ville) VALUES ('Les_Arceaux', 1);
INSERT INTO magasins (name, ville) VALUES ('Sabines', 1);
INSERT INTO magasins (name, ville) VALUES ('Etang_de_l_or', 2);
INSERT INTO magasins (name, ville) VALUES ('Sete', 3);
INSERT INTO magasins (name, ville) VALUES ('Matabiau', 4);


INSERT INTO prestations (label, tarif) VALUES ('pression pneus', 0);
INSERT INTO prestations (label, tarif) VALUES ('peinture', 300);
INSERT INTO prestations (label, tarif) VALUES ('lustrage', 50);
INSERT INTO prestations (label, tarif) VALUES ('controle_technique', 50);


INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('peugeot_206', 1000, '1', 4, 5);
INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('ford_fiesta', 10000, '0', 5, 4);
INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('renault_kangoo', 8000, '1', 5, 3);
INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('fiat_panda', 2000, '1', 4, 2);
INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('honda_civic', 2000, '1', 5, 1);
INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('honda_civic', 2000, '0', 5, 2);
INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('honda_civic', 2000, '0', 5,  5);

INSERT INTO motos (modele, prix, reserve, cylindree, magasin) VALUES ('yamaha_mt_09', 9000, '1', 800, 5);
INSERT INTO motos (modele, prix, reserve, cylindree, magasin) VALUES ('yamaha_mt_10', 16500, '0', 600, 4);
INSERT INTO motos (modele, prix, reserve, cylindree,  magasin) VALUES ('suzuki_gsx', 8899, '1', 950, 3);
INSERT INTO motos (modele, prix, reserve, cylindree, magasin) VALUES ('honda_cb', 2000, '1', 1150, 2);
INSERT INTO motos (modele, prix, reserve, cylindree, magasin) VALUES ('honda_cb', 12500, '1', 1050, 1);
INSERT INTO motos (modele, prix, reserve, cylindree, magasin) VALUES ('bmw_g_310', 6000, '0', 750,  2);
INSERT INTO motos (modele, prix, reserve, cylindree, magasin) VALUES ('harley', 12800, '0', 1250, 5);


//table de jointures
INSERT INTO magasins_proches (magasin_id, magasin_near) VALUES (1, 2);
INSERT INTO magasins_proches (magasin_id, magasin_near) VALUES (1, 3);
INSERT INTO magasins_proches (magasin_id, magasin_near) VALUES (2, 3);


//table de jointures 
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (1, 1);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (1, 3);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (2, 3);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (2, 4);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (3, 1);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (3, 3);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (3, 4);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (4, 1);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (4, 2);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (5, 1);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (5, 2);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (5, 3);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (5, 4);

CREATE DATABASE concessionnaire;

\c concessionnaire

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


/* table de jointure*/
CREATE TABLE join_mag_pres (
magasin_id INTEGER,
prestation_id INTEGER,
PRIMARY KEY (magasin_id, prestation_id),
FOREIGN KEY (magasin_id) REFERENCES magasins(id),
FOREIGN KEY (prestation_id) REFERENCES prestations(id)
);


INSERT INTO villes (name) VALUES ('Montpellier');
INSERT INTO villes (name) VALUES ('Perols');


INSERT INTO magasins (name, ville) VALUES ('Les_Arceaux', 1);
INSERT INTO magasins (name, ville) VALUES ('Sabines', 1);

INSERT INTO prestations (label, tarif) VALUES ('pression pneus', 0);
INSERT INTO prestations (label, tarif) VALUES ('peinture', 300);

INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('peugeot_206', 1000, '1', 4, 5);
INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('ford_fiesta', 10000, '0', 5, 4);


/*table de jointures */
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (1, 1);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (1, 3);
INSERT INTO join_mag_pres (magasin_id, prestation_id) VALUES (2, 3);
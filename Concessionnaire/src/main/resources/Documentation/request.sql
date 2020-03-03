SELECT * FROM magasins;

SELECT * FROM magasins_proches WHERE magasin_id = 2;

SELECT * FROM voitures;

SELECT * FROM voitures WHERE id = 2;

INSERT INTO voitures (modele, prix, reserve, nb_places, magasin) VALUES ('peugeot_206', 1000, '1', 4, 5);

UPDATE voitures SET prix = 16200, reserve = '0' WHERE id = 2;

DELETE FROM voitures WHERE id = 7;

SELECT modele, prix, reserve, magasins.name FROM voitures, magasins, villes WHERE voitures.magasin = magasins.id AND voitures.nb_places = 5 AND magasins.ville = villes.id AND villes.name = 'Montpellier';

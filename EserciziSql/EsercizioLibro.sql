/* Esercizio 1*/
CREATE TABLE 
Libri(
id INT PRIMARY KEY,
titolo VARCHAR(100),
autore VARCHAR(50),
genere VARCHAR(50),
prezzo DECIMAL(5,2),
anno_pubblicazione INT
);
/* Esercizio 2*/
INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES (1, 'La notte dei ricordi', 'Giulia Verdi', 'Narrativa', 12.50, 2020);

INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES (2, 'Oltre il confine', 'Luca Neri', 'Avventura', 16.00, 2016);

INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES (3, 'Le ombre del passato', 'Francesca Rossi', 'Thriller', 13.75, 2021);

INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES (4, 'Viaggio nella memoria', 'Alessandro Gallo', 'Storico', 11.90, 2015);

INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES (5, 'Anime ribelli', 'Elena Moretti', 'Romanzo Psicologico', 15.20, 2019);

INSERT INTO Libri (id, titolo, autore, genere, prezzo, anno_pubblicazione)
VALUES (6, 'Nebbie d’autunno', 'Chiara Fontana', 'Drammatico', 13.40, 2017);

/*Esercizio 3 --*/
SELECT genere, COUNT(*) AS numero_libri, AVG(prezzo) AS prezzo_medio
FROM world.Libri
GROUP BY genere
ORDER BY genere ASC;

/* Esercizio 4*/
SELECT *
FROM Libri
WHERE anno_pubblicazione > 2010
ORDER BY anno_pubblicazione DESC, 
prezzo ASC;



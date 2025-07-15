use world;
CREATE TABLE
Vendite (
    id INT,
    prodotto VARCHAR(100),
    categoria VARCHAR(50),
    quantita INT,
    prezzo_unitario DECIMAL(6,2),
    data_vendita DATE
);

/* Inserimento nella tabella */
INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita)
VALUES (1, 'Laptop HP Pavilion', 'Informatica', 2, 599.99, '2025-07-01');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita)
VALUES (2, 'Mouse Logitech MX Master 3', 'Accessori', 5, 89.90, '2025-07-03');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita)
VALUES (3, 'Samsung Galaxy S23', 'Telefonia', 1, 799.00, '2025-07-05');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita)
VALUES (4, 'Stampante Epson EcoTank', 'Periferiche', 3, 179.50, '2025-07-07');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita)
VALUES (5, 'Monitor LG UltraWide 34"', 'Informatica', 2, 349.99, '2025-07-09');

INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita)
VALUES (6, 'Cuffie Sony WH-1000XM5', 'Accessori', 4, 299.99, '2025-07-12');

/*Query*/


/*count
Totale vendite per categoria
Visualizza, per ogni categoria, il numero totale di vendite effettuate.*/
SELECT categoria, COUNT(*) AS numero_vendite
FROM world.vendite
GROUP BY categoria;


/*MEDIA
Prezzo medio per categoria
Mostra, per ogni categoria, il prezzo medio dei prodotti venduti.*/
SELECT categoria, AVG(prezzo_unitario) AS prezzo_medio
FROM world.vendite
GROUP BY categoria;

/*
Quantità totale venduta per ogni prodotto
 Mostra il totale delle quantità vendute (SUM) per ciascun prodotto.*/
SELECT prodotto, SUM(quantita) AS totale_quantita_venduta
FROM Vendite
GROUP BY prodotto;

/* Prezzo massimo e minimo venduto nella tabella
Mostra il prezzo massimo e il prezzo minimo tra tutti i prodotti venduti.*/
SELECT MAX(prezzo_unitario) AS prezzo_Max,MIN(prezzo_unitario) AS prezzo_Min
FROM world.vendite;


/* Numero totale di righe nella tabella
Conta quante vendite sono state registrate nella tabella Vendite.*/
SELECT COUNT(*) AS numero_totale_vendite
FROM Vendite;

/* LIMIT 5 peodotti più costosi
I 5 prodotti più costosi (in base al prezzo_unitario)
Elenca i 5 prodotti più costosi ordinati in modo decrescente rispetto al prezzo. */
SELECT prodotto, prezzo_unitario
FROM Vendite
ORDER BY prezzo_unitario DESC
LIMIT 5;


/*3 prodotti meno venduti
I 3 prodotti meno venduti per quantità totale
Mostra i nomi dei 3 prodotti con la quantità totale più bassa venduta (usa SUM e LIMIT). */
SELECT prodotto, SUM(quantita) AS totale_quantita_venduta
FROM Vendite
GROUP BY prodotto
ORDER BY totale_quantita_venduta ASC
LIMIT 3;

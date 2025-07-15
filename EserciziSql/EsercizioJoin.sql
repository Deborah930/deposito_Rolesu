use world;
DROP TABLE clienti;
CREATE TABLE
Clienti (
id INT,
nome VARCHAR(100),
città VARCHAR(100)
);
/*inserimento di massa nella tabella clienti*/
INSERT INTO Clienti (id, nome, città) VALUES
(1, 'Marco Rossi', 'Milano'),
(2, 'Luca Bianchi', 'Roma'),
(3, 'Giulia Verdi', 'Napoli'),
(4, 'Sara Neri', 'Torino'),
(5, 'Davide Gallo', 'Bologna'),
(6, 'Elena Ferri', 'Firenze'),
(7, 'Matteo Greco', 'Genova'),
(8, 'Anna Riva', 'Venezia'),
(9, 'Francesco Longo', 'Verona'),
(10, 'Laura Conti', 'Palermo'),
(11, 'Alessandro Fontana', 'Trieste'),
(12, 'Beatrice Galli', 'Parma'),
(13, 'Riccardo Leone', 'Pisa'),
(14, 'Chiara Valentini', 'Lecce'),
(15, 'Giorgio Moretti', 'Cagliari');

/*creazione tabella ordini*/
use world;
DROP TABLE ordini;
CREATE TABLE 
Ordini (
id INT,
id_cliente INT,
data_ordine DATE,
importo DECIMAL(7,2)
);

/*inserimento di massa nella tabella ordini*/
INSERT INTO Ordini (id, id_cliente, data_ordine, importo) VALUES
(1, 1, '2025-01-15', 150.50),
(2, 2, '2025-02-20', 299.99),
(3, 1, '2025-03-05', 75.00),
(4, 3, '2025-04-10', 450.20),
(5, 5, '2025-05-18', 120.00),
(6, 4, '2025-06-01', 89.90),
(7, 2, '2025-06-15', 210.30),
(8, 7, '2025-07-07', 560.00),
(9, 9, '2025-07-10', 320.75),
(10, 6, '2025-07-12', 100.00),
(11, 8, '2025-07-13', 45.99),
(12, 10, '2025-07-14', 88.50),
(13, 11, '2025-07-15', 250.00),
(14, 12, '2025-07-16', 130.75),
(15, 13, '2025-07-17', 90.40);


/* esercizio 1 inner join*/
SELECT clienti.nome,
ordini.data_ordine,
ordini.importo
 FROM world.clienti
INNER JOIN world.ordini
ON clienti.id= ordini.id_cliente;

/*esercizio 2 left join 
visualizza tutti i clienti inclusi quelli che non hanno mai effettuato un ordine */
SELECT clienti.nome AS nome_cliente,
ordini.data_ordine AS ordine_cliente,
ordini.importo AS importo_ordine
FROM world.clienti
LEFT JOIN world.ordini
ON clienti.id= ordini.id_cliente;

/*esercizio 3 RIGHT JOIN 
visualizza tutti gli ordini anche quelli che non hanno un cliente associato*/
SELECT clienti.nome AS nome_cliente,
ordini.data_ordine AS ordine_cliente,
ordini.importo AS importo_ordine
FROM world.ordini
RIGHT JOIN world.clienti
ON clienti.id= ordini.id_cliente;

/* esercizio in più*/

/* elenco dei clienti che hanno effettuato almeno un ordine*/
SELECT clienti.nome,
COUNT(ordini.data_ordine) AS tot_ordine,
SUM(ordini.importo) AS tot_importo
FROM world.clienti
INNER JOIN world.ordini
ON clienti.id= ordini.id_cliente
GROUP BY clienti.nome;


/*elenco dei clienti che non hanno corrispondenza con gli oridni*/
SELECT clienti.nome,
clienti.città
FROM world.clienti
LEFT JOIN world.ordini
ON clienti.id=ordini.id_cliente
WHERE ordini.id_cliente IS NULL;

/* ordini che non hanno un cliente */
SELECT 
clienti.nome,
ordini.id,
ordini.data_ordine,
ordini.importo
FROM world.ordini
RIGHT JOIN world.clienti
ON clienti.id= ordini.id_cliente
WHERE ordini.id_cliente IS NULL;





use world;

/* LIKE */
SELECT autore
FROM world.libri
WHERE autore LIKE 'a%';

SELECT autore
FROM world.libri
WHERE autore LIKE '_l%';

/* IN */
SELECT * FROM world.libri
WHERE genere IN ('narrativa',  'avventura');

SELECT * FROM world.country
WHERE name IN('Germany','France','UK');

/* BETWEEN */
SELECT* FROM world.country
WHERE name BETWEEN 'a' AND 'b';

SELECT*FROM world.libri
WHERE genere BETWEEN 'a' AND 'z';


SELECT * FROM world.libri
WHERE anno_pubblicazione BETWEEN 2010 AND 2016;

SELECT * FROM world.libri
WHERE prezzo BETWEEN 10.00 AND 20.00;

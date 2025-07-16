use world;

/* ESERCIZI 
ci sono join,union, ALL, alias, orde by */

/*ESERCIZIO 1:
Si vuole recuperare dal database WORLD le lingue parlate per nazione con la rispettiva percentuale di utilizzo;*/
SELECT 
c.name AS Nazione,
cl.language AS Lingua,
cl.percentage AS Percentuale
FROM country AS c
INNER JOIN countryLanguage AS cl ON c.Code = cl.countryCode;

/*ESERCIZIO 2:
Si vuole recuperare dal database WORLD le nazioni e la percentuale della lingua più parlata;*/
SELECT 
c.name AS Nazione,
cl.language AS Lingua,
cl.percentage AS Percentuale
FROM country AS c
INNER JOIN countryLanguage cl ON c.Code = cl.countryCode
WHERE cl.percentage >=  ALL( SELECT cl1.percentage FROM countryLanguage AS cl1 WHERE cl1.countryCode = cl.countrycode) -- ottieni la lingua più parlata per ogni nazione --
ORDER BY Percentuale DESC; -- ordina dalla percentuale più alta alla più piccola--
-- order by va sempre alla fine--

/*ESERCIZIO 3:
Unire gli esercizi 1 e 2 facendole diventare subQuery per mostrare la lingua più parlata di una nazione con la percentuale;*/
SELECT 
c.Name AS Nazione,
cl.Language AS Lingua_Più_Parlata,
cl.Percentage AS Percentuale
FROM country c
INNER JOIN countrylanguage cl ON c.Code = cl.CountryCode
WHERE cl.Percentage = (SELECT MAX(cl2.Percentage)FROM countrylanguage cl2 WHERE cl2.CountryCode = c.Code)
ORDER BY Percentuale DESC;




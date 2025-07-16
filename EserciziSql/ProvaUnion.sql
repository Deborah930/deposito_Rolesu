
use world;
/*UNION */
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
LEFT JOIN Country ON City.CountryCode = Country.Code
UNION -- unisce solamente i dati coerenti--
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
RIGHT JOIN Country ON City.CountryCode = Country.Code;


/*Union all*/
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
LEFT JOIN Country ON City.CountryCode = Country.Code
UNION ALL -- unisce tutti i campi--
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City
RIGHT JOIN Country ON City.CountryCode = Country.Code;


/*esercizio */
use world;
/* Si vogliono recuperare dal database "world" la lingua e la nazione di ogni città.*/
SELECT 
c.Name AS Nazione,
ci.Name AS Capitale,
cl.Language AS Lingua
FROM Country  AS c
JOIN 
CountryLanguage AS cl ON c.Code = cl.CountryCode
JOIN 
City AS ci ON c.Capital = ci.ID
ORDER BY 
c.Name, cl.Percentage DESC;

/* esercizio 2
Si vuole recuperare il numero di città per nazione dal database "world" mostrando anche il nome della nazione e ordinarli in base al numero di città.*/
SELECT 
c.Name AS Nazione,
COUNT(ci.ID) AS NumeroCitta
FROM Country AS c
JOIN City AS ci ON c.Code = ci.CountryCode
GROUP BY c.Name
ORDER BY NumeroCitta DESC;

/*esercizio 3
Si vuole conoscere la lista di repubbliche con aspettativa di vita maggiore dei 70 anni, inoltre si vuole visualizzare anche la lingua parlata.*/




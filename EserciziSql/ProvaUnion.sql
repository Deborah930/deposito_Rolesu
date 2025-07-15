
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


/*esercizio con UNION*/
use world;
/* Si vogliono recuperare dal database "world" la lingua e la nazione di ogni città.*/
SELECT 
countrylanguage.Language,
country.name
FROM country
LEFT JOIN countrylanguage
ON country.code= countrylanguage.CountryCode
UNION
SELECT 
countrylanguage.Language,
country.name
FROM country
RIGHT JOIN countrylanguage
ON country.code= countrylanguage.CountryCode;


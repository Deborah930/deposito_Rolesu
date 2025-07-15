use world;
/* inner join*/
SELECT country.continent,country.code,countrylanguage.CountryCode AS country
FROM world.country 
INNER JOIN world.countrylanguage
ON country.code= countrylanguage.countrycode;

/*inner join*/
SELECT city.name,city.CountryCode, country.name, country.code AS country
FROM world.city
INNER JOIN world.country
ON city.CountryCode= country.code;

/* left join  tutta la tabella di sinistra con valori in comune */
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM world.city
LEFT JOIN world.country ON City.CountryCode = Country.Code;

/*right join tutta la tabella di destra con valori in comune*/
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM world.city
LEFT JOIN world.country ON City.CountryCode = Country.Code;

/* full outer join/ cross join prende tutto*/
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM world.city
CROSS JOIN world.country;


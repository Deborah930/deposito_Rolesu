SELECT DISTINCT region 
FROM world.country
WHERE continent='Europe';

SELECT name, population
FROM world.city
WHERE CountryCode='USA' AND population>1000000
ORDER BY name ASC;

-- 3) GROUP BY con aggregazioni
SELECT Continent, COUNT(*) AS Numero_Paesi, SUM(Population) AS Popolazione_Totale
FROM Country
GROUP BY Continent
ORDER BY Popolazione_Totale DESC;



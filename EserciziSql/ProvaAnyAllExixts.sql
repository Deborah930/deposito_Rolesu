
use world;
/*HAVING*/
SELECT CountryCode, COUNT(*) AS NumeroLingue
FROM CountryLanguage
WHERE IsOfficial = 'T'
GROUP BY CountryCode
HAVING COUNT(*) > 1;

SELECT Country.Name, COUNT(*) AS NumeroLingue
FROM Country
JOIN CountryLanguage ON Country.Code = CountryLanguage.CountryCode
WHERE CountryLanguage.IsOfficial = 'T'
GROUP BY Country.Name
HAVING COUNT(*) > 1;

SELECT Country.Name, COUNT(City.ID) AS NumeroCittà
FROM Country
JOIN City ON Country.Code = City.CountryCode
GROUP BY Country.Name
HAVING COUNT(City.ID) > 10
ORDER BY NumeroCittà DESC;


/*EXIXST
Per ogni riga in Country, la subquery controlla se esiste almeno una città con lo stesso CountryCode.*/
SELECT 
c.Name AS Nazione
FROM Country c
WHERE EXISTS (SELECT 1 FROM City ci WHERE ci.CountryCode = c.Code);

/*ANY */
SELECT 
c.Name AS Nazione,
c.Population AS Popolazione
FROM Country c
WHERE c.Population > ANY (SELECT ci.Population FROM City ci)-- è vera se la popolazione della nazione è maggiore di almeno una città.--
-- Risultato: praticamente tutte le nazioni, perché ogni paese ha più abitanti di almeno una città piccola. --
ORDER BY c.Population DESC;

/*è vera se la lingua in un altro paese ha una percentuale maggiore di almeno una lingua parlata negli USA.*/
SELECT 
c.Name AS Nazione,
cl.Language AS Lingua,
cl.Percentage AS Percentuale
FROM Country c
JOIN CountryLanguage cl ON c.Code = cl.CountryCode
WHERE cl.Percentage > ANY (SELECT cl2.Percentage FROM CountryLanguage cl2 JOIN Country c2 ON cl2.CountryCode = c2.Code WHERE c2.Name = 'United States')
ORDER BY cl.Percentage DESC;
/* restituisce tutte le lingue che sono più diffuse in un paese rispetto a qualche lingua negli USA (anche il 0.1% conta).*/



/*ALL */
SELECT 
Name AS Nazione,
Population AS Popolazione
FROM Country
WHERE Population > ALL (SELECT Population FROM City) -- è vera solo se la popolazione del paese è maggiore della popolazione di OGNI città. --
ORDER BY Population DESC;

SELECT Language, Percentage
FROM CountryLanguage
WHERE Percentage > ALL (SELECT Percentage FROM CountryLanguage WHERE CountryCode = 'ITA'); -- la percentuale di questa lingua è più alta di qualsiasi lingua in Italia --
-- restituisce tutte le percentuali delle lingue parlate in Italia. --

SELECT Name, CountryCode, Population
FROM City
WHERE Population > ALL ( SELECT Population FROM City WHERE CountryCode = 'ITA'); -- ritorna chi ha la popolazione maggiore rispetto della popolazione città che ha code ITA--



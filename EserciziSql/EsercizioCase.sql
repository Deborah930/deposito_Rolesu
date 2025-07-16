/*
Esercizio2:
recuperare e mostrare le città con il codice della nazione che indica l'utente. Inoltre l'utente può decidere:
l'ordine con cui ordinare le città in maniera decrescente o meno;
se filtrare le città per un minimo di popolazione;
se mostrare il nome della nazione a cui fa riferimento il code;
*/
use world;
SELECT 
    c.Name AS Città,
    c.Population AS Popolazione,
    CASE 
        WHEN 'SI' = 'SI' THEN co.Name  -- si decide se far vedere la nazione -- 
        ELSE '----' -- altrimenti non si vede niente--
    END AS Nazione -- alias--
FROM city AS c
JOIN country AS co ON c.CountryCode = co.Code
WHERE c.CountryCode = 'ITA'       -- codice scelto dall'utente--
  AND c.Population >= 100000       -- numero di popolazione scelto dall'utente
ORDER BY 
-- l'utente sceglie se vedere la lista in modo crescente o decrescente --
CASE 
WHEN 'ASC' = 'ASC' THEN c.Name 
END ASC,
CASE
WHEN 'DESC' = 'DESC' THEN c.name  
END DESC;        



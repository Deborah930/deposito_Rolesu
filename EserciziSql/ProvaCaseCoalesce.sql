use world;
/* CASE */
SELECT
Name AS Città,
Population AS Popolazione,
CASE
WHEN Population > 5000000 THEN 'Megalopoli' -- controllo dove la popolazione è più grande di 5000000 do il nome di megalopoli--
WHEN Population > 1000000 THEN 'Grande città' -- controllo se in  la popolazione è più grande di 1000000 do il nome di grande città --
WHEN Population > 500000 THEN 'Media città' -- controllo se in  la popolazione è più grande di 5000000 do il nome di media città  --
ELSE 'Piccola città' -- altrimenti do il nome di piccola città--
END AS Categoria -- da un alias --
FROM City
ORDER BY Population DESC;

SELECT 
name AS nazione,
region as regione
FROM country
ORDER BY
(CASE WHEN nazione IS NULL THEN regione
ELSE nazione
END);


/*IFNULL()*/



/*COALESCE*/
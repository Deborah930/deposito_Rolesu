use world;

/*Creare una view di city del database world su una query che
mostra le città italiane.*/
CREATE VIEW city_view AS
SELECT 
name,
countryCode,
population
FROM city
WHERE countryCode='ITA';
DROP VIEW city_view;




/*Su questa VIEW eseguire una query che mostra solo le città
con una popolazione inferiore ai 100k.*/
SELECT 
name,
population
FROM city_view
WHERE population < 100000;

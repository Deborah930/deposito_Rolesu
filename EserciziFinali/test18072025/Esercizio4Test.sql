-- 1. Elenca tutti i film rilasciati dopo il 2005, ordinati per titolo in ordine alfabetico.  -- 
use sakila;
SELECT title, release_year
FROM film
WHERE release_year > 2005
ORDER BY title ASC;

-- 2.Mostra tutti i noleggi (rental) effettuati da un cliente di nome Mary Smith. --
SELECT r.rental_id, r.rental_date, f.title, c.first_name, c.last_name
FROM customer AS c
JOIN rental AS r ON c.customer_id = r.customer_id
JOIN inventory AS i ON r.inventory_id = i.inventory_id
JOIN film AS f ON i.film_id = f.film_id
WHERE c.first_name = 'MARY' AND c.last_name = 'SMITH'
ORDER BY r.rental_date;

-- 3. Per ogni film, mostra il numero totale di volte in cui è stato noleggiato (usa JOIN e GROUP BY). --
SELECT f.title, COUNT(r.rental_id) AS total_rentals
FROM film AS f
JOIN inventory AS i ON f.film_id = i.film_id
JOIN rental AS r ON i.inventory_id = r.inventory_id
GROUP BY f.film_id, f.title;

-- 4.  Elenca i nomi dei film che non sono mai stati noleggiati. --
SELECT f.title
FROM film AS f
WHERE f.film_id NOT IN (
    SELECT i.film_id
    FROM inventory AS i
    JOIN rental AS r ON i.inventory_id = r.inventory_id
);

-- 5.Trova il genere (category) con il maggior numero di noleggi.--
SELECT c.name AS category, COUNT(*) AS totale_noleggi
FROM rental AS r
JOIN inventory AS i ON r.inventory_id = i.inventory_id
JOIN film_category AS fc ON i.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
GROUP BY c.name
ORDER BY totale_noleggi DESC;

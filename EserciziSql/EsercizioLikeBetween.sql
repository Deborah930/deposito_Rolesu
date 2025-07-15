use world;
DROP  TABLE Clienti;
CREATE TABLE
Clienti (
id INT,
nome VARCHAR(100),
cognome VARCHAR(100),
email VARCHAR(100),
eta INT,
citta VARCHAR(100)
);
/* inserimento in tabella*/
INSERT INTO Clienti (id, nome, cognome, email, eta, citta) VALUES
(1, 'Alessandro', 'Bianchi', 'alessandro.b@gmail.com', 32, 'Roma'),         
(2, 'Andrea', 'Rossi', 'andrea.r@gmail.com', 35, 'Milano'),                 
(3, 'Anna', 'Verdi', 'anna.v@gmail.com', 29, 'Roma'),                       
(4, 'Antonio', 'Neri', 'antonio.neri@yahoo.com', 40, 'Roma'),              
(5, 'Alice', 'Santi', 'alice.santi@hotmail.com', 28, 'Torino'),             
(6, 'Marco', 'Pelle', 'marco.pelle@libero.it', 33, 'Roma'),                
(7, 'Luca', 'Grato', 'luca.grato@outlook.com', 38, 'Napoli'),               
(8, 'Giulia', 'Vinci', 'giulia.vinci@gmail.com', 41, 'Bologna'),            
(9, 'Elena', 'Ferri', 'elena.ferri@gmail.com', 36, 'Firenze'),              
(10, 'Simone', 'Bruni', 'simone.bruni@hotmail.com', 39, 'Roma'); 

/*QUERY*/
/* controllo dei clienti che hanno un dominio gmail.com*/
SELECT * FROM world.clienti
WHERE email LIKE '%gmail.com';

/* per cercare caratteri speciali come @*/
SELECT * FROM world.clienti
WHERE  REGEXP_LIKE (email,'@gmail.com');

/*clienti con nome che inizia con la lettera 'a'*/

SELECT* FROM world.clienti
WHERE nome LIKE 'A%';

/*Clienti con cognome che contiene esattamente 5 lettere*/
SELECT * FROM world.clienti
WHERE cognome LIKE '_____';    -- 5 underscore = 5 caratteri --

/*clienti con un età compresa tra i 30 e i 40 anni*/
SELECT * FROM world.clienti
WHERE eta BETWEEN 30 AND 40;



/* clienti che vivono a Roma*/
SELECT * FROM world.clienti
WHERE citta LIKE '%roma%';




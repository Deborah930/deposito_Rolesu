CREATE DATABASE prova;
use prova;
CREATE TABLE Persons (
PersonID int,
LastName varchar(255),
FirstName varchar(255),
Address varchar(255),
City varchar(255)
);

DROP TABLE tabella;
DROP DATABASE prova;

use prova;
/*Copia tabella*/
CREATE TABLE TestTable
SELECT PersonID,
LastName,
FirstName,
Address,
City
FROM  persons;

use prova;
/*VIEW PER riportare una tabella a visualizzazione*/
CREATE VIEW persona AS
SELECT PersonID,
LastName,
FirstName,
Address,
City
FROM  persons;

/*eliminazione view*/
DROP VIEW persona;

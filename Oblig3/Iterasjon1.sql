-- SQL for en-til-mange-eksemplet gjennomgått i timen onsdag 13. mars 2024 

DROP SCHEMA IF EXISTS Iterasjon1 CASCADE;
CREATE SCHEMA Iterasjon1;
SET search_path TO Iterasjon1;
    
CREATE TABLE Ansatt
(
	ansattId INTEGER PRIMARY KEY,
	ansettelseDato DATE NOT NULL,
	brukernavn varchar(30) UNIQUE NOT NULL,
	fornavn varchar(30) NOT NULL,
	etternavn varchar(30) NOT NULL,
	stilling varchar(30) NOT NULL,
	månedslønn DECIMAL NOT NULL
);


INSERT INTO
  Ansatt(ansattId, ansettelseDato, brukernavn, fornavn, etternavn, stilling, månedslønn)
VALUES
    (1, '2023-05-10', 'funnyguy87', 'Bob', 'McLaughlin', 'Chief Fun Officer', 10000.00),
    (2, '2022-11-15', 'lolmaster', 'Chad', 'Thunderstorm', 'Director of Memes', 9000.50),
    (3, '2023-02-28', 'quirkyqueenie', 'Alice', 'Wacky', 'Master of Puns', 8500.75),
    (4, '2022-08-20', 'sillysally', 'Sally', 'Goofball', 'Vice President of Silliness', 12000.00),
    (5, '2023-09-03', 'jokesterjohn', 'John', 'Whimsy', 'Minister of Laughter', 11000.25);


Select * from Ansatt;

    
    
    
    
-- SQL for en-til-mange-eksemplet gjennomgått i timen onsdag 13. mars 2024 

DROP SCHEMA IF EXISTS Iterasjon3 CASCADE;
CREATE SCHEMA Iterasjon3;
SET search_path TO Iterasjon3;
    
CREATE TABLE Ansatt
(
	ansattId SERIAL PRIMARY KEY,
	ansettelsesDato DATE NOT NULL,
	brukernavn varchar(30) UNIQUE NOT NULL,
	fornavn varchar(30) NOT NULL,
	etternavn varchar(30) NOT NULL,
	stilling varchar(30) NOT NULL,
	manedslonn DECIMAL NOT NULL,
	avdelingId Integer
	
);



Select * from Ansatt;



   CREATE TABLE Avdeling
(
	avdelingId SERIAL PRIMARY KEY,
	navn varchar(30) NOT NULL,
	sjef INTEGER REFERENCES Ansatt(ansattId)
);
 ALTER TABLE Ansatt
 ADD CONSTRAINT avdelingId FOREIGN KEY(avdelingId) REFERENCES Avdeling(avdelingId);

INSERT INTO
  Ansatt(ansettelsesDato, brukernavn, fornavn, etternavn, stilling, manedslonn)
VALUES
    ('2023-05-10', 'funnyguy87', 'Bob', 'McLaughlin', 'Chief Fun Officer', 10000.00),
    ('2022-11-15', 'lolmaster', 'Chad', 'Thunderstorm', 'Director of Memes', 9000.50),
    ('2023-02-28', 'quirkyqueenie', 'Alice', 'Wacky', 'Master of Puns', 8500.75),
    ('2022-08-20', 'sillysally', 'Sally', 'Goofball', 'Vice President of Silliness', 12000.00),
    ('2023-09-03', 'jokesterjohn', 'John', 'Whimsy', 'Minister of Laughter', 11000.25);


INSERT INTO avdeling(navn, sjef)
VALUES
  ('Innovation Hub', 1),
  ('Cybernetic Solutions', 2),
  ('Galactic Ventures', 3),
  ('FutureTech Industries', 4),
  ('Quantum Dynamics', 5);


Select * from Avdeling, Ansatt;

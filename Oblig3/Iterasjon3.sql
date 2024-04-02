
DROP SCHEMA IF EXISTS Iterasjon3 CASCADE;
CREATE SCHEMA Iterasjon3;
SET search_path TO Iterasjon3;
    
CREATE TABLE Ansatt
(
	ansattID SERIAL PRIMARY KEY,
	ansettelsesDato DATE NOT NULL,
	brukernavn varchar(30) UNIQUE NOT NULL,
	fornavn varchar(30) NOT NULL,
	etternavn varchar(30) NOT NULL,
	stilling varchar(30) NOT NULL,
	manedslonn DECIMAL NOT NULL,
	avdelingsID Integer
);

CREATE TABLE Avdeling(
	avdelingsID SERIAL PRIMARY KEY,
	navn varchar(30) NOT NULL,
	sjef INTEGER REFERENCES Ansatt(ansattID)
);

INSERT INTO Ansatt(ansettelsesDato, brukernavn, fornavn, etternavn, stilling, manedslonn, avdelingsID)
VALUES
    ('2023-05-10', 'funnyguy87', 'Bob', 'McLaughlin', 'Chief Fun Officer', 10000.00, 1),
    ('2022-11-15', 'lolmaster', 'Chad', 'Thunderstorm', 'Director of Memes', 9000.50, 2),
    ('2023-02-28', 'quirkyqueenie', 'Alice', 'Wacky', 'Master of Puns', 8500.75, 3),
    ('2022-08-20', 'sillysally', 'Sally', 'Goofball', 'Vice President of Silliness', 12000.00, 4),
    ('2023-09-03', 'jokesterjohn', 'John', 'Whimsy', 'Minister of Laughter', 11000.25, 5);

Select * from Ansatt;

INSERT INTO Avdeling(navn, sjef) VALUES
  ('Innovation Hub', 1),
  ('Cybernetic Solutions', 2),
  ('Galactic Ventures', 3),
  ('FutureTech Industries', 4),
  ('Quantum Dynamics', 5);

Select * from Avdeling;

ALTER TABLE Ansatt
ADD CONSTRAINT FK_Avdeling FOREIGN KEY(avdelingsID) REFERENCES Avdeling(avdelingsID);

Select * from Ansatt, Avdeling where Avdeling.avdelingsID = Ansatt.avdelingsID;
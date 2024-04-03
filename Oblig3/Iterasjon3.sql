
DROP SCHEMA IF EXISTS Iterasjon3 CASCADE;
CREATE SCHEMA Iterasjon3;
SET search_path TO Iterasjon3;
    
CREATE TABLE Ansatt
(
	ansattID SERIAL PRIMARY KEY,
	ansettelsesDato DATE, 
	brukernavn varchar(30) UNIQUE,
	fornavn varchar(30),
	etternavn varchar(30),
	stilling varchar(30),
	manedslonn DECIMAL,
	avdelingsID Integer NOT NULL
);

CREATE TABLE Avdeling(
	avdelingsID SERIAL PRIMARY KEY,
	avdelingsnavn varchar(30),
	sjef integer,
	FOREIGN KEY (sjef) REFERENCES Ansatt(ansattID)
);

INSERT INTO Ansatt(ansettelsesDato, brukernavn, fornavn, etternavn, stilling, manedslonn, avdelingsID)
VALUES
    ('2023-05-10', 'funnyguy87', 'Bob', 'McLaughlin', 'Chief Fun Officer', 10000.00, 1),
    ('2022-11-15', 'lolmaster', 'Chad', 'Thunderstorm', 'Director of Memes', 9000.50, 2),
    ('2023-02-28', 'quirkyqueenie', 'Alice', 'Wacky', 'Master of Puns', 8500.75, 3),
    ('2022-08-20', 'sillysally', 'Sally', 'Goofball', 'Vice President of Silliness', 12000.00, 4),
    ('2023-09-03', 'jokesterjohn', 'John', 'Whimsy', 'Minister of Laughter', 11000.25, 5),
	('2023-12-12', 'hilarioushannah', 'Hannah', 'Joker', 'Head of Comedy', 10500.50, 2),
    ('2024-01-25', 'gigglegeorge', 'George', 'Guffaw', 'Laughing Liaison', 9500.25, 5),
    ('2023-06-30', 'whimsicalwanda', 'Wanda', 'Merryweather', 'Chief Chuckler', 10200.75, 5),
    ('2024-03-15', 'laughinglarry', 'Larry', 'Grins', 'Humor Consultant', 9800.00, 4),
    ('2023-08-08', 'mirthfulmary', 'Mary', 'Smiles', 'Jester-in-Chief', 10750.00, 1);


Select * from Ansatt;

INSERT INTO Avdeling(avdelingsnavn, sjef) VALUES
  ('Innovation Hub', 1),
  ('Cybernetic Solutions', 2),
  ('Galactic Ventures', 3),
  ('FutureTech Industries', 4),
  ('Quantum Dynamics', 5);

Select * from Avdeling;

ALTER TABLE Ansatt
ADD FOREIGN KEY(avdelingsID) REFERENCES Avdeling(avdelingsID);

Select * from Ansatt, Avdeling where Avdeling.avdelingsID = Ansatt.avdelingsID;
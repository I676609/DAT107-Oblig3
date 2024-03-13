package no.hvl.dat107.Iterasjon1;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Iterasjon1")
public class Prosjekt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektid;
	
	private String navn;
	private String beskrivelse;
	private String bokstav;
	

	@ManyToOne
	@JoinColumn(name = "ansattid")
	private List<Ansatt> deltagere;
}

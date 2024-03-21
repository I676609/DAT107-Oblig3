package no.hvl.dat107.Iterasjon3;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import no.hvl.dat107.Iterasjon1.Ansatt;

@Entity
@Table(schema = "Iterasjon1")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingsId;
	private String avdelingsnavn;
	@OneToOne
	private Ansatt leder;

	@Override
	public String toString() {
		return "Karakter [karnr=" + karnr + ", emnekode=" + emnekode + ", eksdato=" + eksdato + ", bokstav=" + bokstav
				 + "]";
	}

	private String emnekode;
	private LocalDate eksdato;
	private String bokstav;

	@ManyToOne
	@JoinColumn(name = "studnr")
	private Ansatt vitnemal;
}

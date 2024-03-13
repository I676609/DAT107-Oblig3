package no.hvl.dat107.Iterasjon1;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Iterasjon1")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int karnr;

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

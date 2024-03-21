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
@Table(schema = "Iterasjon3")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingsId;
	private String avdelingsnavn;
	private Ansatt leder;
	
	public Avdeling() {}
	
	public Avdeling (int avdelingsId, String avdelingsnavn, Ansatt leder) {
		this.avdelingsId = avdelingsId;
		this.avdelingsnavn = avdelingsnavn;
		this.leder = leder;
	}

	public int getAvdelingsId() {
		return avdelingsId;
	}

	public void setAvdelingsId(int avdelingsId) {
		this.avdelingsId = avdelingsId;
	}

	public String getAvdelingsnavn() {
		return avdelingsnavn;
	}

	public void setAvdelingsnavn(String avdelingsnavn) {
		this.avdelingsnavn = avdelingsnavn;
	}

	public Ansatt getLeder() {
		return leder;
	}

	public void setLeder(Ansatt leder) {
		this.leder = leder;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	@Override
	public String toString() {
		return "AvdelingsID [aID=" + avdelingsId + ", Avdelingsnavn=" + avdelingsnavn + ", Leder=" + leder + "]";
	}


	@ManyToOne
	@JoinColumn(name = "ansattId")
	private Avdeling avdeling;
}

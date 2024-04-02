package no.hvl.dat107.Iterasjon3;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Iterasjon3")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingsID;
	private String avdelingsnavn;

	@OneToOne
	@JoinColumn(name = "ansattID")
	private Ansatt leder;
	@ManyToOne
	@JoinColumn(name = "ansattID")
	private List<Ansatt> deltagere;

	public Avdeling() {
	}

	public Avdeling(String avdelingsnavn) {
		this.avdelingsnavn = avdelingsnavn;
	}

	public Avdeling(String avdelingsnavn, Ansatt leder) {
		this.avdelingsnavn = avdelingsnavn;
		this.leder = leder;
	}

	public int getAvdelingsID() {
		return avdelingsID;
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

	@Override
	public String toString() {
		return "Avdeling [avdelingsID=" + avdelingsID + ", Navn=" + avdelingsnavn + ", Leder=" + leder + "]";
	}
}

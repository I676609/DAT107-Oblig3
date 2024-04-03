package no.hvl.dat107.Firma;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Firma")
public class Avdeling {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingsID;
	private String avdelingsnavn;

	@OneToOne
	@JoinColumn(name = "sjef", referencedColumnName = "ansattID")
	private Ansatt sjef;


	public Avdeling() {
	}

	public Avdeling(String avdelingsnavn) {
		this.avdelingsnavn = avdelingsnavn;
	}

	public Avdeling(String avdelingsnavn, Ansatt sjef) {
		this.avdelingsnavn = avdelingsnavn;
		this.sjef = sjef;
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
		return sjef;
	}

	public void setLeder(Ansatt leder) {
		this.sjef = leder;
	}

	public void skrivUt() {
		System.out.println("AvdelingsID: " + avdelingsID);
		System.out.println("Avdelingsnavn: " + avdelingsnavn);
		System.out.println("Sjef: " + sjef.getFornavn() + " " + sjef.getEtternavn());
		System.out.println();
	}

	@Override
	public String toString() {
		return "Avdeling [avdelingsID=" + avdelingsID + ", Navn=" + avdelingsnavn + ", Sjef=" + sjef + "]";
	}
}

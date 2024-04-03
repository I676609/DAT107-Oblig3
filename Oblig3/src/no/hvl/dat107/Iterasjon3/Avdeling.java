package no.hvl.dat107.Iterasjon3;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@JoinColumn(name = "sjef", referencedColumnName = "ansattID")
	private Ansatt sjef;
	@OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Ansatt> ansatte=new ArrayList<>();

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

	@Override
	public String toString() {
		return "Avdeling [avdelingsID=" + avdelingsID + ", Navn=" + avdelingsnavn + ", Leder=" + sjef + "]";
	}
}

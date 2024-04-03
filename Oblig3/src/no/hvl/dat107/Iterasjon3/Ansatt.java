package no.hvl.dat107.Iterasjon3;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Iterasjon3")
public class Ansatt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansattID;
	
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansettelsesDato;
	private String stilling;
	private BigDecimal manedslonn;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "avdelingsID", referencedColumnName = "avdelingsID")
	private Avdeling avdeling;

	public Ansatt() {
	}

	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesDato, String stilling,
			BigDecimal manedslonn, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesDato = ansettelsesDato;
		this.stilling = stilling;
		this.manedslonn = manedslonn;
		this.avdeling = avdeling;
	}

	@Override
	public String toString() {
		return "Ansatt [ansattID=" + ansattID + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelsesDato=" + ansettelsesDato + ", stilling=" + stilling + ", manedslonn="
				+ manedslonn + "]";
	}

	public int getAnsattID() {
		return ansattID;
	}

	public void setAnsattID(int ansattID) {
		this.ansattID = ansattID;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsettelseDato() {
		return ansettelsesDato;
	}

	public void setAnsettelseDato(LocalDate ansettelseDato) {
		this.ansettelsesDato = ansettelseDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public BigDecimal getManedslonn() {
		return manedslonn;
	}

	public void setManedslonn(BigDecimal manedslonn) {
		this.manedslonn = manedslonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	public void skrivUt() {
		System.out.println("AnsattID: " + ansattID);
		System.out.println("Brukernavn: " + brukernavn);
		System.out.println("Fornavn: " + fornavn);
		System.out.println("Etternavn: " + etternavn);
		System.out.println("AnsettelsesDato: " + ansettelsesDato);
		System.out.println("Stilling: " + stilling);
		System.out.println("Månedslønn: " + manedslonn);
	}
}

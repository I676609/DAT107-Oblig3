package no.hvl.dat107.Iterasjon2;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "iterasjon1")
public class Ansatt {
	@Id
	private int ansattId;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansettelsesDato;
	private String stilling;
	private BigDecimal manedslonn;
	
	

	@Override
	public String toString() {
		return "Ansatt:\nAnsattId: " + ansattId + "\nBrukernavn: " + brukernavn + "\nFornavn: " + fornavn + "\nEtternavn: "
				+ etternavn + "\nAnsettelsesDato: " + ansettelsesDato + "\nStilling: " + stilling + "\nMånedslønn: "
				+ manedslonn + "\n";
	}

	public int getAnsattId() {
		return ansattId;
	}

	public void setAnsattId(int ansattId) {
		this.ansattId = ansattId;
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

	public void setManedslonn(BigDecimal månedslønn) {
		this.manedslonn = månedslønn;
	}

	public void skrivUt() {
		System.out.println(toString() + "\n");
	}
}

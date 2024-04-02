package no.hvl.dat107.Iterasjon1;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(schema = "Iterasjon1")
@Entity
public class Ansatt {
	@Id
	private int ansattID;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansettelsesDato;
	private String stilling;
	private BigDecimal manedslonn;
	
	@Override
	public String toString() {
		return "Ansatt [ansattID=" + ansattID + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansettelsesDato=" + ansettelsesDato + ", stilling=" + stilling + ", månedslønn="
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

	public void setManedslonn(BigDecimal månedslønn) {
		this.manedslonn = månedslønn;
	}

	public void skrivUt() {
		System.out.println(toString() + "\n");
	}
}

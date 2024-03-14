package no.hvl.dat107.Iterasjon2;

import static javax.swing.JOptionPane.showInputDialog;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Tekstgrensesnitt {
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Ansatt lesAnsatt() {
		Ansatt ansatt = new Ansatt();
		ansatt.setAnsattId(Integer.parseInt(showInputDialog("AnsattId:")));
		ansatt.setBrukernavn(showInputDialog("Brukernavn:"));
		ansatt.setFornavn(showInputDialog("Fornavn:"));
		ansatt.setEtternavn(showInputDialog("Etternavn"));
		ansatt.setAnsettelseDato(LocalDate.parse(showInputDialog("Ansettelsesdato:")));
		ansatt.setStilling(showInputDialog("Stilling:"));
		ansatt.setManedslonn(BigDecimal.valueOf(Double.parseDouble(showInputDialog("Månedslønn"))));
		return ansatt;
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("Filmnummer: " + film.getFilmnr());
		System.out.println("Filmskaper: " + film.getFilmskaper());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("År: " + film.getAar());
		System.out.println("Sjanger: " + film.getSjanger());
		System.out.println("Filmselskap: " + film.getFilmselskap() + "\n");
	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		System.out.println("Filmer med " + delstreng + " i tittelen:\n");

		for (Film f : arkiv.soekTittel(delstreng)) {
			skrivUtFilm(f);
		}
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		System.out.println("Filmer med " + delstreng + " i navnet til produsenten:");

		for (Film f : arkiv.soekProdusent(delstreng)) {
			skrivUtFilm(f);
		}
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Antall filmer i arkivet:\nTotalt: " + arkiv.antall());
		for (Sjanger s : Sjanger.values()) {
			System.out.println(s + ": " + arkiv.antall(s));
		}
		System.out.println();
	}
}
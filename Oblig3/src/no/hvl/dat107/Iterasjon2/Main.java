package no.hvl.dat107.Iterasjon2;

import static javax.swing.JOptionPane.showInputDialog;

import java.math.BigDecimal;

public class Main {
	private static AnsattDAO ansattDAO;

	public static void main(String[] args) {
		Boolean kjorer = true;
		while (kjorer) {
			ansattDAO = new AnsattDAO();
			String s = showInputDialog(
					"Hva ønsker du å gjøre?\nFinn (Finner en ansatt)\nAlle (Skriver ut alle ansatte)\nOppdater (For å oppdatere en ansatt)\nLegg til (For å legge til en ny ansatt)");

			if (s == null || s.toLowerCase().contains("quit") || s.toLowerCase().contains("stop")) {
				kjorer = false;
			} else if (s.toLowerCase().contains("finn")) {
				finnAnsatt();
			} else if (s.toLowerCase().contains("alle")) {
				for (Ansatt a : ansattDAO.finnAlleAnsatte()) {
					a.skrivUt();
				}
			} else if (s.toLowerCase().contains("oppdater")) {
				oppdater();
			} else if (s.toLowerCase().contains("legg til")) {
				ansattDAO.leggTilAnsatt();
				System.out.println("Ny ansatt lagt til!");
			}

		}

	}

	private static void finnAnsatt() {
		String s = showInputDialog("Vil du finne ansatt via brukernavn eller ID?");
		if (s.toLowerCase().contains("id")) {
			System.out.println(ansattDAO.finnAnsattMedId(Integer.parseInt(showInputDialog("Hva er ansatt sin ID?"))));
		} else if (s.toLowerCase().contains("brukernavn")) {
			System.out.println(ansattDAO.finnAnsattMedBrukernavn(showInputDialog("Hva er ansatt sitt burkernavn?")));
		} else {
			System.out.println("Ulovlig input!!");
		}
	}

	private static void oppdater() {
		String s = showInputDialog("Vil du oppdatere stilling eller lønn?");
		String a = showInputDialog("Vil du finne avsatt ved ID eller Brukernavn?");
		if (s.toLowerCase().contains("stilling")) {
			if (a.toLowerCase().contains("id"))
				ansattDAO.oppdaterAnsattStilling(Integer.parseInt(showInputDialog("Skriv inn ansatt id")),
						showInputDialog("Skriv inn stilling"));
			else if (a.toLowerCase().contains("brukernavn"))
				ansattDAO.oppdaterAnsattStilling(showInputDialog("Hva er ansatt sitt brukernavn?"),
						showInputDialog("Skriv inn stilling"));
			else
				System.out.println("Ulivlig input!!");
		} else if (s.toLowerCase().contains("lønn")) {
			if (a.toLowerCase().contains("id"))
				ansattDAO.oppdaterAnsattLonn(Integer.parseInt(showInputDialog("Skriv inn ansatt id")),
						BigDecimal.valueOf(Double.parseDouble(showInputDialog("Skriv inn ny lønn"))));
			else if (a.toLowerCase().contains("brukernavn"))
				ansattDAO.oppdaterAnsattLonn(showInputDialog("Hva er ansatt sitt brukernavn?"),
						BigDecimal.valueOf(Double.parseDouble(showInputDialog("Skriv inn ny lønn"))));
			else
				System.out.println("Ulivlig input!!");
		} else {
			System.out.println("Ulovlig input!!");
		}
	}
}

package no.hvl.dat107.Iterasjon2;

import static javax.swing.JOptionPane.showInputDialog;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		Boolean kjorer = true;
		while (kjorer) {
			AnsattDAO ansattDAO = new AnsattDAO();
			String s = showInputDialog(
					"Hva ønsker du å gjøre?\nFinn ansatt id/brukernavn, Skriv ut alle ansatte, Oppdater, stilling, lønn, Legg til ny ansatt");

			if (s.toLowerCase().contains("quit") || s.toLowerCase().contains("stopp")) {
				kjorer = false;
			} else if (s.toLowerCase().contains("id")) {
				System.out.println(ansattDAO.finnAnsattMedId(Integer.parseInt(showInputDialog("Skriv inn ansatt id"))));

			} else if (s.toLowerCase().contains("brukernavn")) {
				System.out.println(ansattDAO.finnAnsattMedBrukernavn(showInputDialog("Skriv inn burkernavn")));
			} else if (s.toLowerCase().contains("skriv ut alle") || s.toLowerCase().contains("alle")) {
				for (Ansatt a : ansattDAO.finnAlleAnsatte()) {
					a.skrivUt();
				}
			} else if (s.toLowerCase().contains("stilling")) {
				String a = showInputDialog("Oppdater via ID eller Brukernavn?");
				if (a.toLowerCase().contains("id")) {
					ansattDAO.oppdaterAnsattStilling(Integer.parseInt(showInputDialog("ansattId?")),
							showInputDialog("Skriv inn ny stilling"));
				} else if (a.toLowerCase().contains("brukernavn")) {
					ansattDAO.oppdaterAnsattStilling(showInputDialog("Brukernavn?"),
							showInputDialog("Skriv inn ny stilling"));
				} else {
					System.out.println("Ulovelig input!!");
				}
			} else if (s.toLowerCase().contains("lønn")) {
				String a = showInputDialog("Oppdater via ID eller Brukernavn?");
				if (a.toLowerCase().contains("id")) {
					ansattDAO.oppdaterAnsattLonn(Integer.parseInt(showInputDialog("Ansattid?")),
							BigDecimal.valueOf(Double.parseDouble(showInputDialog("Skriv inn ny lønn:"))));
				} else if (a.toLowerCase().contains("brukernavn")) {
					ansattDAO.oppdaterAnsattLonn(showInputDialog("Brukernavn?"),
							BigDecimal.valueOf(Double.parseDouble(showInputDialog("Skriv inn ny lønn:"))));

				} else {
					System.out.println("Ulovelig input!!");
				}
			}

		}

	}
}

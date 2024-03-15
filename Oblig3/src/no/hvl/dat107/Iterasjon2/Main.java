package no.hvl.dat107.Iterasjon2;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {

	public static void main(String[] args) {
		Boolean kjorer = true;
		while (kjorer) {
			AnsattDAO ansattDAO = new AnsattDAO();
			String s = showInputDialog(
					"Hva ønsker du å gjøre? \n Finn ansatt id/brukernavn, Skriv ut alle ansatte, Oppdater, stilling, lønn, Legg til ny ansatt");

			if (s.toLowerCase().contains("quit") || s.toLowerCase().contains("stopp")) {
				kjorer = false;
			} else if (s.contains("Finn ansatt id") || s.toLowerCase().contains("id")) {
				System.out.println(ansattDAO.finnAnsattMedId(Integer.parseInt(showInputDialog("Skriv inn ansatt id"))));

			} else if (s.toLowerCase().contains("finn ansatt brukernavn") || s.toLowerCase().contains("brukernavn")) {
				System.out.println(ansattDAO.finnAnsattMedBrukernavn(showInputDialog("Skriv inn burkernavn")));
			} else if (s.toLowerCase().contains("skriv ut alle") || s.toLowerCase().contains("alle")) {
				for (Ansatt a : ansattDAO.finnAlleAnsatte()) {
					a.skrivUt();
				}
			} else if (s.toLowerCase().contains("oppdater stilling")) {
				String a = showInputDialog("Id eller Brukernavn?");
				if (a.toLowerCase().contains("id")) {
					ansattDAO.oppdaterAnsattStilling(Integer.parseInt(showInputDialog("ansattId?")),
							showInputDialog("Skriv inn ny stilling"));
				} else if (a.toLowerCase().contains("brukernavn")) {
					ansattDAO.oppdaterAnsattStilling(showInputDialog("Brukernavn?"),
							showInputDialog("Skriv inn ny stilling"));
				} else {
					System.out.println("Ulovelig input!!");
				}
			}

		}

		// Hente ut en ansattBru
	}
}

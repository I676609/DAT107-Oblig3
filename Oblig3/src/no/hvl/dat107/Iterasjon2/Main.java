package no.hvl.dat107.Iterasjon2;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {

	public static void main(String[] args) {
		Boolean kjorer = true;
		while (kjorer) {
			String s = showInputDialog(
					"Hva ønsker du å gjøre? \n (Finn ansatt, id, brukernavn), (Skriv ut alle ansatte), (Oppdater, Stilling, lønn), (Legg til ny ansatt)");
			if (s.contains("Quit") || s.contains("stopp") || s.contains("Stopp")) {
				kjorer = false;
			}
			if (s.contains("Finn ansatt id")) {
				AnsattDAO ansattDAO = new AnsattDAO();
				System.out.println(ansattDAO.finnAnsattMedId(Integer.parseInt(showInputDialog("Skriv inn ansatt id"))));

			}
		}

		// Hente ut en ansatt
	}
}

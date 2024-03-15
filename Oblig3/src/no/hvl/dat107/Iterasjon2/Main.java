package no.hvl.dat107.Iterasjon2;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {

	public static void main(String[] args) {
		Boolean kjorer = true;
		while (kjorer) {
			AnsattDAO ansattDAO = new AnsattDAO();
			String s = showInputDialog(
					"Hva ønsker du å gjøre? \n Finn ansatt id/brukernavn, Skriv ut alle ansatte, Oppdater, Stilling, lønn, Legg til ny ansatt");
			
			if (s.contains("Quit") || s.contains("stopp") || s.contains("Stopp")) {
				kjorer = false;
			} else if (s.contains("Finn ansatt id") || s.contains("id") || s.contains("Id")) {
				System.out.println(ansattDAO.finnAnsattMedId(Integer.parseInt(showInputDialog("Skriv inn ansatt id"))));

			} else if (s.contains("Finn ansatt brukernavn") || s.contains("Brukernavn") || s.contains("brukernavn")) {
				System.out.println(ansattDAO.finnAnsattMedBrukernavn(showInputDialog("Skriv inn burkernavn")));
			}
		}

		// Hente ut en ansattBru
	}
}

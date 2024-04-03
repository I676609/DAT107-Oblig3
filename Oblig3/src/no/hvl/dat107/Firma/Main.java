package no.hvl.dat107.Firma;

import static javax.swing.JOptionPane.showInputDialog;

import java.math.BigDecimal;

public class Main {
	private static AnsattDAO ansattDAO;
	private static AvdelingDAO avdelingDAO;

	public static void main(String[] args) {
		ansattDAO = new AnsattDAO();
		avdelingDAO = new AvdelingDAO();

		Boolean kjorer = true;
		while (kjorer) {
			String s = showInputDialog(
					"Hva ønsker du å gjøre?\nFinn an/av (Finner en ansatt/avdeling)\nAvdelinger (Skriver ut alle avdelinger)\nAlle an (Skriver ut alle ansatte)\nAlle av (Skriver ut ansatte i én avdeling)\nOppdater (For å oppdatere en ansatt)\nLegg til (For å legge til en ny ansatt/avdeling)").toLowerCase();

			if (s == null || s.contains("quit") || s.contains("stop")) {
				kjorer = false;
			} else if (s.contains("finn an")) {
				finnAnsatt();
			} else if (s.contains("alle an")) {
				for (Ansatt a : ansattDAO.finnAlleAnsatte()) {
					a.skrivUt();
				}
			} else if (s.contains("alle av")) {
				for (Ansatt a : ansattDAO.finnAnsatteIAvdeling(Integer.parseInt(showInputDialog("AvdelingsID:")))) {
					a.skrivUt();
				}
			} else if (s.contains("oppdater")) {
				oppdater();
			} else if (s.contains("legg til")) {
				String a = showInputDialog("Vil du legge til Ansatt eller Avdeling?").toLowerCase();
				if (a.contains("an")) {
				ansattDAO.leggTilAnsatt();
				System.out.println("Ny ansatt lagt til!");
				} else if (a.contains("av")) {
					avdelingDAO.leggTilAvdeling();
					System.out.println("Ny avdeling lagt til!");
				} else
					System.out.println("Ulovlig input!");
			} else if (s.contains("finn av")) {
				finnAvdeling();
			}
			else if (s.contains("avdelinger")) {
				for (Avdeling a : avdelingDAO.finnAlleAvdelinger()) {
					a.skrivUt();
				}
			}
		}
	}

	private static void finnAvdeling() {
		String s = showInputDialog("Skriv inn avdelingsID");
		avdelingDAO.finnAvdelingMedID(Integer.parseInt(s)).skrivUt();
	}

	private static void finnAnsatt() {
		String s = showInputDialog("Vil du finne ansatt via brukernavn eller ID?").toLowerCase();
		if (s.contains("id")) {
			ansattDAO.finnAnsattMedID(Integer.parseInt(showInputDialog("ID:"))).skrivUt();
		} else if (s.contains("brukernavn")) {
			ansattDAO.finnAnsattMedBrukernavn(showInputDialog("Hva er ansatt sitt burkernavn?")).skrivUt();
		} else {
			System.out.println("Ulovlig input!");
		}
	}

	private static void oppdater() {
		String str = showInputDialog("Oppdater Ansatt eller Avdeling?").toLowerCase();
		if (str.contains("an")) {
			String s = showInputDialog("Vil du oppdatere stilling eller lønn?").toLowerCase();
			String a = showInputDialog("Vil du finne ansatt ved ID eller Brukernavn?").toLowerCase();
			if (s.contains("stilling")) {
				if (a.contains("id")) {
					ansattDAO.oppdaterAnsattStilling(Integer.parseInt(showInputDialog("ID:")),
							showInputDialog("Ny stilling:"));
					System.out.println("Stilling oppdatert!");

				} else if (a.contains("brukernavn")) {
					ansattDAO.oppdaterAnsattStilling(showInputDialog("Brukernavn:"), showInputDialog("Ny stilling:"));
					System.out.println("Stilling oppdatert!");
				} else
					System.out.println("Ulivlig input!");

			} else if (s.contains("lønn")) {
				if (a.contains("id")) {
					ansattDAO.oppdaterAnsattLonn(Integer.parseInt(showInputDialog("ID:")),
							BigDecimal.valueOf(Double.parseDouble(showInputDialog("Ny lønn:"))));
					System.out.println("Lønn oppdatert!");
				} else if (a.contains("brukernavn")) {
					ansattDAO.oppdaterAnsattLonn(showInputDialog("Brukernavn:"),
							BigDecimal.valueOf(Double.parseDouble(showInputDialog("Ny lønn:"))));
					System.out.println("Lønn oppdatert!");
				} else
					System.out.println("Ulivlig input!");
			} else {
				System.out.println("Ulovlig input!");
			}
		} else {
			ansattDAO.oppdaterAvdeling(Integer.parseInt(showInputDialog("Ansatt ID:")),
					Integer.parseInt(showInputDialog("ny avdelingsID:")));
		}
	}
}
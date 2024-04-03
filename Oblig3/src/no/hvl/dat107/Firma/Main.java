package no.hvl.dat107.Firma;

import java.math.BigDecimal;
import static javax.swing.JOptionPane.showInputDialog;

public class Main {
	private static AnsattDAO ansattDAO;
	private static AvdelingDAO avdelingDAO;

	public static void main(String[] args) {

		Boolean kjorer = true;
		while (kjorer) {
			ansattDAO = new AnsattDAO();
			avdelingDAO = new AvdelingDAO();

			String s = showInputDialog(
					"Hva ønsker du å gjøre?\nFinn an/av (Finner en ansatt/avdeling)\nAlle (Skriver ut alle ansatte)\nOppdater (For å oppdatere en ansatt)\nLegg til (For å legge til en ny ansatt)");

			if (s == null || s.toLowerCase().contains("quit") || s.toLowerCase().contains("stop")) {
				kjorer = false;
			} else if (s.toLowerCase().contains("finn an")) {
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
			} else if (s.toLowerCase().contains("finn av")) {
				finnAvdeling();
			}

		}

	}

	private static void finnAvdeling() {
		String s = showInputDialog("Skriv inn avdelingsID");
		System.out.println(avdelingDAO.finnAvdelingMedID(Integer.parseInt(s)));

	}

	private static void finnAnsatt() {
		String s = showInputDialog("Vil du finne ansatt via brukernavn eller ID?");
		if (s.toLowerCase().contains("id")) {
			ansattDAO.finnAnsattMedID(Integer.parseInt(showInputDialog("ID:"))).skrivUt();
		} else if (s.toLowerCase().contains("brukernavn")) {
			ansattDAO.finnAnsattMedBrukernavn(showInputDialog("Hva er ansatt sitt burkernavn?")).skrivUt();
		} else {
			System.out.println("Ulovlig input!");
		}
	}

	private static void oppdater() {
		String s = showInputDialog("Vil du oppdatere stilling eller lønn?");
		String a = showInputDialog("Vil du finne ansatt ved ID eller Brukernavn?");
		if (s.toLowerCase().contains("stilling")) {
			if (a.toLowerCase().contains("id")) {
				ansattDAO.oppdaterAnsattStilling(Integer.parseInt(showInputDialog("ID:")),
						showInputDialog("Ny stilling:"));
				System.out.println("Stilling oppdatert!!!!!!");
			} else if (a.toLowerCase().contains("brukernavn")) {
				ansattDAO.oppdaterAnsattStilling(showInputDialog("Brukernavn:"), showInputDialog("Ny stilling:"));
				System.out.println("Stilling oppdatert!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			} else
				System.out.println("Ulivlig input!");
		} else if (s.toLowerCase().contains("lønn")) {
			if (a.toLowerCase().contains("id")) {
				ansattDAO.oppdaterAnsattLonn(Integer.parseInt(showInputDialog("ID:")),
						BigDecimal.valueOf(Double.parseDouble(showInputDialog("Ny lønn:"))));
				System.out.println("Lønn oppdatert!!!!!!!!!!!");
			}else if (a.toLowerCase().contains("brukernavn")) {
				ansattDAO.oppdaterAnsattLonn(showInputDialog("Brukernavn:"),
						BigDecimal.valueOf(Double.parseDouble(showInputDialog("Ny lønn:"))));
				System.out.println("Lønn oppdatert!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}else
				System.out.println("Ulivlig input!");
		} else {
			System.out.println("Ulovlig input!");
		}

//	public static void lagEksempler() {
//		Avdeling tattoine = new Avdeling("Tattoine");
//		Avdeling endor = new Avdeling("Endor");
//		Avdeling hoth = new Avdeling("hoth");

//		Ansatt anakinSkywalker = new Ansatt("anakinskywalker", "Anakin", "Skywalker", LocalDate.of(2005, 03, 05),
//				"The Chosen One", BigDecimal.valueOf(500000), tattoine);
//
//		Ansatt lukeSkywalker = new Ansatt("lukeskywalker", "Luke", "Skywalker", LocalDate.of(1977, 5, 25),
//				"Jedi Knight", BigDecimal.valueOf(100000), endor);
//
//		Ansatt leiaOrgana = new Ansatt("leiaorgana", "Leia", "Organa", LocalDate.of(1977, 5, 25), "General",
//				BigDecimal.valueOf(95000), hoth);
//
//		Ansatt hanSolo = new Ansatt("hansolo", "Han", "Solo", LocalDate.of(1977, 5, 25), "Smuggler",
//				BigDecimal.valueOf(90000), hoth);
//
//		Ansatt darthVader = new Ansatt("darthvader", "Darth", "Vader", LocalDate.of(1977, 5, 25), "Sith Lord",
//				BigDecimal.valueOf(120000), tattoine);
//
//		Ansatt obiWanKenobi = new Ansatt("obiwankenobi", "Obi-Wan", "Kenobi", LocalDate.of(1977, 5, 25), "Jedi Master",
//				BigDecimal.valueOf(110000), endor);
//
//		Ansatt yoda = new Ansatt("yoda", "Yoda", "", LocalDate.of(1977, 5, 25), "Grand Master",
//				BigDecimal.valueOf(150000), endor);
//
//		Ansatt padmeAmidala = new Ansatt("padmeamidala", "Padmé", "Amidala", LocalDate.of(1977, 5, 25), "Senator",
//				BigDecimal.valueOf(85000), hoth);
//
//		Ansatt bobaFett = new Ansatt("bobafett", "Boba", "Fett", LocalDate.of(1977, 5, 25), "Bounty Hunter",
//				BigDecimal.valueOf(95000), tattoine);
//
//		Ansatt maceWindu = new Ansatt("macewindu", "Mace", "Windu", LocalDate.of(1977, 5, 25), "Jedi Master",
//				BigDecimal.valueOf(105000), endor);
//
//		Ansatt emperorPalpatine = new Ansatt("emperorpalpatine", "Emperor", "Palpatine", LocalDate.of(1977, 5, 25),
//				"Galactic Emperor", BigDecimal.valueOf(200000), hoth);

	}
}

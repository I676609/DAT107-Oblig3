package no.hvl.dat107.Iterasjon3;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDate;

import no.hvl.dat107.Iterasjon2.Ansatt;
import no.hvl.dat107.Iterasjon2.AnsattDAO;

public class Main {

	public static void main(String[] args) {

		
	}
	
	public void lagEksempler() {
		Ansatt anakinSkywalker = new Ansatt(0, "anakinskywalker", "Anakin", "Skywalker", LocalDate.of(2005, 03, 05), "The Chosen One", BigDecimal.valueOf(500000));
		Ansatt lukeSkywalker = new Ansatt(1, "lukeskywalker", "Luke", "Skywalker", LocalDate.of(1977, 5, 25), "Jedi Knight", BigDecimal.valueOf(100000));
		Ansatt leiaOrgana = new Ansatt(2, "leiaorgana", "Leia", "Organa", LocalDate.of(1977, 5, 25), "General", BigDecimal.valueOf(95000));
		Ansatt hanSolo = new Ansatt(3, "hansolo", "Han", "Solo", LocalDate.of(1977, 5, 25), "Smuggler", BigDecimal.valueOf(90000));
		Ansatt darthVader = new Ansatt(4, "darthvader", "Darth", "Vader", LocalDate.of(1977, 5, 25), "Sith Lord", BigDecimal.valueOf(120000));
		Ansatt obiWanKenobi = new Ansatt(5, "obiwankenobi", "Obi-Wan", "Kenobi", LocalDate.of(1977, 5, 25), "Jedi Master", BigDecimal.valueOf(110000));
		Ansatt yoda = new Ansatt(6, "yoda", "Yoda", "", LocalDate.of(1977, 5, 25), "Grand Master", BigDecimal.valueOf(150000));
		Ansatt padmeAmidala = new Ansatt(7, "padmeamidala", "Padmé", "Amidala", LocalDate.of(1977, 5, 25), "Senator", BigDecimal.valueOf(85000));
		Ansatt bobaFett = new Ansatt(8, "bobafett", "Boba", "Fett", LocalDate.of(1977, 5, 25), "Bounty Hunter", BigDecimal.valueOf(95000));
		Ansatt maceWindu = new Ansatt(9, "macewindu", "Mace", "Windu", LocalDate.of(1977, 5, 25), "Jedi Master", BigDecimal.valueOf(105000));
		Ansatt emperorPalpatine = new Ansatt(10, "emperorpalpatine", "Emperor", "Palpatine", LocalDate.of(1977, 5, 25), "Galactic Emperor", BigDecimal.valueOf(200000));

		Avdeling tattoine = new Avdeling();
		Avdeling endor = new Avdeling();
		Avdeling hoth = new Avdeling();
	}
}

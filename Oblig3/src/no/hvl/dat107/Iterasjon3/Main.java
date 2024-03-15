package no.hvl.dat107.Iterasjon3;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.hvl.dat107.Iterasjon2.Ansatt;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FirmaPU");
		EntityManager em = emf.createEntityManager();
		
				
		Ansatt bjarne = new Ansatt(2, "BjarneTheMan69", "Bjarne", "Imsdal", LocalDate.of(2015, 01, 01) , "Leder", BigDecimal.valueOf(6900000));
		Ansatt jens = new Ansatt(3, "Jensemann", "jens", "sjokolade", LocalDate.of(2013, 02, 01) , "Utvikler", BigDecimal.valueOf(6900000));
		Ansatt ivan = new Ansatt(4, "IvanDenGrusomme", "ivan", "bord", LocalDate.of(2017, 03, 02) , "Utvikler", BigDecimal.valueOf(6900000));
		Ansatt simon = new Ansatt(5, "SimonLemon", "simon", "vindu", LocalDate.of(2019, 04, 13) , "Utvikler", BigDecimal.valueOf(6900000));
		Ansatt oliver = new Ansatt(6, "OliverCoolGuy", "oliver", "stolen", LocalDate.of(2005, 05, 02) , "Utvikler", BigDecimal.valueOf(6900000));
		Ansatt markus = new Ansatt(7, "Markimus", "markussen", "markissen", LocalDate.of(2006, 06, 19) , "Utvikler", BigDecimal.valueOf(6900000));
		Ansatt katrine = new Ansatt(8, "Katta", "katrine", "jenssen", LocalDate.of(2001, 07, 26) , "HR", BigDecimal.valueOf(500000));
		Ansatt helle = new Ansatt(9, "Hellerisning", "helle", "hellesen", LocalDate.of(2009, 05, 17) , "HR", BigDecimal.valueOf(500000));
		Ansatt snus = new Ansatt(10, "testing", "snusen", "snusen", LocalDate.of(2006, 10, 30) , "Stress", BigDecimal.valueOf(89));
		Ansatt boks = new Ansatt(11, "grandis", "boks", "boksen", LocalDate.of(2015, 10, 31) , "Stress", BigDecimal.valueOf(20));

		String test = "INSERT INTO Ansatt VALUES "
		
	}

}

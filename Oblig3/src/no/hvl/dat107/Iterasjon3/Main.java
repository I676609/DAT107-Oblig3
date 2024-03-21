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
		Ansatt employee1 = new Ansatt(1, "jensemann", "Jens", "Jenssen", LocalDate.of(2005, 03, 05), "Leder", BigDecimal.valueOf(500000));
		Ansatt employee2 = new Ansatt(2, "annasmith", "Anna", "Smith", LocalDate.of(2010, 10, 15), "Manager", BigDecimal.valueOf(70000));
		Ansatt employee3 = new Ansatt(3, "mikeross", "Mike", "Ross", LocalDate.of(2008, 05, 20), "Senior Developer", BigDecimal.valueOf(90000));
		Ansatt employee4 = new Ansatt(4, "lindawilliams", "Linda", "Williams", LocalDate.of(2015, 12, 10), "HR Coordinator", BigDecimal.valueOf(60000));
		Ansatt employee5 = new Ansatt(5, "davidjones", "David", "Jones", LocalDate.of(2007, 08, 25), "Financial Analyst", BigDecimal.valueOf(75000));
		Ansatt employee6 = new Ansatt(6, "emilybrown", "Emily", "Brown", LocalDate.of(2012, 04, 03), "Marketing Specialist", BigDecimal.valueOf(65000));
		Ansatt employee7 = new Ansatt(7, "kevinwilson", "Kevin", "Wilson", LocalDate.of(2009, 11, 18), "Project Manager", BigDecimal.valueOf(85000));
		Ansatt employee8 = new Ansatt(8, "sarahjackson", "Sarah", "Jackson", LocalDate.of(2018, 07, 07), "Software Engineer", BigDecimal.valueOf(80000));
		Ansatt employee9 = new Ansatt(9, "chriscarter", "Chris", "Carter", LocalDate.of(2013, 09, 12), "Sales Representative", BigDecimal.valueOf(70000));
		Ansatt employee10 = new Ansatt(10, "natalieyoung", "Natalie", "Young", LocalDate.of(2016, 02, 28), "Accountant", BigDecimal.valueOf(72000));

	}

}

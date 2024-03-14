package no.hvl.dat107.Iterasjon1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("firmaPU");
		EntityManager em = emf.createEntityManager();
		// a) Hente ut en ansatt
		try {
			System.out.println(em.find(Ansatt.class, 1));
		} finally {
			em.close();
		}
	}
}
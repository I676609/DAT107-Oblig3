package no.hvl.dat107.Iterasjon1;

import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattDAO {

	private EntityManagerFactory emf;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("AnsattPU",
				Map.of("jakarta.persistence.jdbc.password", "123ivan123"));
	}

	/* --------------------------------------------------------------------- */

	public Ansatt hentNavn(int ansattId) {

		EntityManager em = emf.createEntityManager();
		try {

			return em.

		} finally {
			em.close();
		}
	}
	

	/* --------------------------------------------------------------------- */

	public /* TODO */void hentKarakterForStudentIEmne(/* TODO */) {

		EntityManager em = emf.createEntityManager();

		try {

			/* TODO */

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public /* TODO */void registrerKarakterForStudent(/* TODO */) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			/* TODO */

			tx.commit();

		} finally {
			em.close();
		}
	}

	/* --------------------------------------------------------------------- */

	public List<Avdeling> hentKarakterlisteForFerdige(String emnekode) {

		EntityManager em = emf.createEntityManager();

		try {

			/*
			 * Finne liste av DAT107-karakterer for studenter som er ferdig (har sluttdato).
			 * Forventer kun denne: (1, DAT107, '2022-05-30', 'A', 123456)
			 * 
			 * I SQL kan det se slik ut: SELECT k.* FROM karakter AS k NATURAL JOIN vitnemal
			 * AS v WHERE v.studieslutt IS NOT NULL AND k.emnekode LIKE 'DAT107';
			 */

			String jpqlQuery = """
					select k
					from Karakter as k,
					k.vitnemal as v
					where v.studieslutt is not null
					and k.emnekode like :emnekode""";

			TypedQuery<Avdeling> query = em.createQuery(jpqlQuery, Avdeling.class);
			query.setParameter("emnekode", emnekode);

			return query.getResultList();

		} finally {
			em.close();
		}
	}

}

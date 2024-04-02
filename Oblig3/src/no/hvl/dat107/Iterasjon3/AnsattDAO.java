package no.hvl.dat107.Iterasjon3;

import static javax.swing.JOptionPane.showInputDialog;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AnsattDAO {

	private EntityManagerFactory emf;
	private AvdelingDAO avdelingDAO;

	public AnsattDAO() {
		emf = Persistence.createEntityManagerFactory("firmaPU");
	}

	public Ansatt finnAnsattMedID(int ansattID) {

		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Ansatt.class, ansattID);
		} finally {
			em.close();
		}
	}

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Ansatt> query = em.createQuery("select a from Ansatt a where a.brukernavn = :brukernavn",
					Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	public List<Ansatt> finnAlleAnsatte() {

		EntityManager em = emf.createEntityManager();

		try {
			return em.createQuery("select a from Ansatt as a", Ansatt.class).getResultList();
		} finally {
			em.close();
		}
	}

	public void oppdaterAnsattStilling(int ansattID, String stilling) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.find(Ansatt.class, ansattID).setStilling(stilling);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void oppdaterAnsattStilling(String brukernavn, String stilling) {
		oppdaterAnsattStilling(finnAnsattMedBrukernavn(brukernavn).getAnsattID(), stilling);
	}

	public void oppdaterAnsattLonn(int ansattID, BigDecimal lonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.find(Ansatt.class, ansattID).setManedslonn(lonn);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void oppdaterAnsattLonn(String brukernavn, BigDecimal lonn) {
		oppdaterAnsattLonn(finnAnsattMedBrukernavn(brukernavn).getAnsattID(), lonn);
	}

	public void oppdaterAnsattStillingOgLonn(int ansattID, String stilling, BigDecimal lonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Ansatt managed = em.find(Ansatt.class, ansattID);
			managed.setStilling(stilling);
			managed.setManedslonn(lonn);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void oppdaterAnsattStillingOgLonn(String brukernavn, String stilling, BigDecimal lonn) {
		oppdaterAnsattStillingOgLonn(finnAnsattMedBrukernavn(brukernavn).getAnsattID(), stilling, lonn);
	}

	public void leggTilAnsatt(Ansatt a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			em.persist(a);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		}
	}

	public void leggTilAnsatt() {
		leggTilAnsatt(new Ansatt(showInputDialog("Brukernavn:"),
				showInputDialog("Fornavn:"), showInputDialog("Etternavn"),
				LocalDate.parse(showInputDialog("AnsettelsesDato: (yyyy-mm-dd")), showInputDialog("Stilling:"),
				BigDecimal.valueOf(Double.parseDouble(showInputDialog("Månedslønn:"))),
				avdelingDAO.finnAvdelingMedID(Integer.parseInt(showInputDialog("AvdelingsID:")))));
	}
}
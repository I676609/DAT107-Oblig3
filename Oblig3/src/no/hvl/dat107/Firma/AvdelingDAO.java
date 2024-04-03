package no.hvl.dat107.Firma;

import static javax.swing.JOptionPane.showInputDialog;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AvdelingDAO {
	private EntityManagerFactory emf;

	public AvdelingDAO() {
		emf = Persistence.createEntityManagerFactory("firmaPU");
	}

	public Avdeling finnAvdelingMedID(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
	}

	public void leggTilAvdeling(Avdeling a) {
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

	public void leggTilAvdeling() {
		EntityManager em = emf.createEntityManager();
		leggTilAvdeling(new Avdeling(showInputDialog("Avdelingsnavn:"),
				em.find(Ansatt.class, showInputDialog("AnsattID til sjef:"))));
	}
}

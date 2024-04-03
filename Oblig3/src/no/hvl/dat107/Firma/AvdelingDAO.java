package no.hvl.dat107.Firma;

import static javax.swing.JOptionPane.showInputDialog;

import java.util.List;

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
		Ansatt ansatt = em.find(Ansatt.class, Integer.parseInt(showInputDialog("AnsattID til sjef:")));
		Avdeling avdeling = new Avdeling(showInputDialog("Avdelingsnavn:"), ansatt);
		leggTilAvdeling(avdeling);
		AnsattDAO ansattDAO = new AnsattDAO();
		ansattDAO.oppdaterAvdeling(ansatt.getAnsattID(), avdeling.getAvdelingsID());
	}
	public List<Avdeling> finnAlleAvdelinger() {

		EntityManager em = emf.createEntityManager();

		try {
			return em.createQuery("select a from Avdeling as a order by a.avdelingsID", Avdeling.class).getResultList();
		} finally {
			em.close();
		}
	}
}

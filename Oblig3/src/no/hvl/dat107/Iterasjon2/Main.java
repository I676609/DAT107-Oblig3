package no.hvl.dat107.Iterasjon2;

public class Main {

	public static void main(String[] args) {
		AnsattDAO ansattDAO = new AnsattDAO();

		// Hente ut en ansatt
		System.out.println(ansattDAO.finnAnsattMedId(1));
	}
}

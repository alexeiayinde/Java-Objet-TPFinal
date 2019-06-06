package dev;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		LocalDate date1 = LocalDate.of(1983, 3, 28);

		ProprietairePhysique proprio1 = new ProprietairePhysique("Alexei", "Nantes", LocalDate.of(1987, 3, 28));

		ProprietaireSociete proprio2 = new ProprietaireSociete("Alexandre", "Nantes", "Delphine");

		CompteCourant compte1 = new CompteCourant(proprio1);
		compte1.verserEspece(200);
		compte1.setDecouvert(-100);
		try {
			compte1.retirerEspece(250);
		} catch (RetraitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompteEpargne compte4 = new EpargneLDD(proprio1);

		CompteCourant compte2 = new CompteCourant(proprio2);

		proprio1.addCompte(compte1);
		proprio1.addCompte(compte4);

		CompteEpargne compte3 = new EpargneLDD(proprio2);

		Banque bank = new Banque();

		bank.addProprio(proprio1);
		bank.addProprio(proprio2);

		System.out.println(bank.getAccounts(proprio1));
		System.out.println("\n");

		System.out.println(bank.getListeCompte().get(0).getSolde());
		System.out.println(compte1.getSolde());

		try {
			bank.getListeCompte().get(0).verserEspece(200);
		} catch (VersementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(bank.getListeCompte().get(0).getSolde());
		System.out.println(compte1.getSolde());

	}

}

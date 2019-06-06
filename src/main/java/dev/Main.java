package dev;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {

		LocalDate date1 = LocalDate.of(1983, 3, 28);

		ProprietairePhysique proprio1 = new ProprietairePhysique("Alexei", "Nantes", LocalDate.of(1987, 3, 28));
		ProprietaireSociete proprio2 = new ProprietaireSociete("Alexandre", "Nantes", "Delphine");
		ProprietairePhysique proprio3 = new ProprietairePhysique("Anna", "Nantes", LocalDate.of(1992, 12, 23));

		Compte compte1 = new CompteCourant(proprio1);
		Compte compte2 = new EpargneLDD(proprio1);
		Compte compte4 = new CompteCourant(proprio2);
		Compte compte5 = new EpargneLEP(proprio3);

		Banque bank = new Banque();

		bank.addProprio(proprio1);
		bank.addProprio(proprio2);
		bank.addProprio(proprio3);

		bank.addVirementAuto(new VirementAuto(compte1, compte2, 100));

		System.out.println(bank.getSoldeTotal(proprio3));

	}

}

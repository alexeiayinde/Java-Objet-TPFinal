package dev;

import java.time.LocalDate;

public final class ProprietairePhysique extends Proprietaire {

	private LocalDate dateDeNaissance;

	public ProprietairePhysique(String nom, String adresse, LocalDate dateDeNaissance) {
		super(nom, adresse);
		this.dateDeNaissance = dateDeNaissance;
		this.typeProprietaire = "Personne physique";
	}

}

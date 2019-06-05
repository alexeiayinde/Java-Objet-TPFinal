package dev;

public final class ProprietaireSociete extends Proprietaire {

	private String gerant;

	public ProprietaireSociete(String nom, String adresse, String gerant) {
		super(nom, adresse);
		this.gerant = gerant;
		this.typeProprietaire = "Société";
	}

}

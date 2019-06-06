package dev;

public final class ProprietaireSociete extends Proprietaire {

	private String gerant;

	public ProprietaireSociete(String nom, String adresse, String gerant) {
		super(nom, adresse);
		this.gerant = gerant;
		this.typeProprietaire = "Société";
	}

	@Override
	public String toString() {
		return super.toString() + "\nGérant de la société : " + this.gerant;
	}

	public String getGerant() {
		return gerant;
	}

	public void setGerant(String gerant) {
		this.gerant = gerant;
	}

}

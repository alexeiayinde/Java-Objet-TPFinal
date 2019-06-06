package dev;

public final class CompteCourant extends Compte {

	private double decouvert;

	public CompteCourant(Proprietaire proprio) {
		super(proprio);
		this.decouvert = 0;
		this.solde = 0f;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
		System.out.println("Le nouveau découvert est de " + this.decouvert + "€.");
	}

	@Override
	public void retirerEspece(float amount) throws RetraitException {
		if (this.solde - amount >= decouvert)
			this.solde -= amount;
		else
			throw new RetraitException("Retrait impossible ! Vous dépasserez votre découvert autorisé.");
	}

	@Override
	public void verserEspece(float amount) {
		this.solde += amount;
	}

}

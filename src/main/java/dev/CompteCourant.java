package dev;

public final class CompteCourant extends Compte {

	private float decouvert;

	public CompteCourant(Proprietaire proprio) {
		this(proprio, 0);
	}

	public CompteCourant(Proprietaire proprio, float decouvert) {
		super(proprio);
		this.decouvert = decouvert;
	}

	public float getDecouvert() {
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

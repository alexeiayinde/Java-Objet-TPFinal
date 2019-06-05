package dev;

public final class CompteCourant extends Compte {

	private double decouvert;

	public CompteCourant(Proprietaire proprio) {
		super(proprio);
		this.decouvert = 0;
		this.solde = 0;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	@Override
	public void retirerEspece(double amount) throws RetraitException {
		if (this.solde - amount >= decouvert)
			this.solde -= amount;
		else
			throw new RetraitException("Retrait impossible ! Vous dépasserez votre découvert autorisé.");
	}

	@Override
	public void verserEspece(double amount) {
		this.solde += amount;
	}

}

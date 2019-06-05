package dev;

public abstract class CompteEpargne extends Compte {

	protected double montantMin, montantMax;

	public CompteEpargne(Proprietaire proprio) {
		super(proprio);
	}

	@Override
	public void verserEspece(double amount) throws VersementException {
		if (this.solde + amount <= montantMax)
			this.solde += amount;
		else
			throw new VersementException("Versement impossible ! Vous dépasserez le solde maximum autorisé.");

	}

	@Override
	public void retirerEspece(double amount) throws RetraitException {
		if (this.solde - amount >= montantMin)
			this.solde -= amount;
		else
			throw new RetraitException("Retrait impossible ! Vous dépasserez le solde minimum autorisé.");
	}

	public abstract void appliquerInterets();

}

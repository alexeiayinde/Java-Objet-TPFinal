package dev;

public abstract class CompteEpargne extends Compte {

	protected float montantMin, montantMax, tauxInteret;

	public CompteEpargne(Proprietaire proprio) {
		super(proprio);
	}

	@Override
	public void verserEspece(float amount) throws VersementException {
		if (this.solde + amount <= montantMax)
			this.solde += amount;
		else
			throw new VersementException("Versement impossible ! Vous dépasserez le solde maximum autorisé.");

	}

	@Override
	public void retirerEspece(float amount) throws RetraitException {
		if (this.solde - amount >= montantMin)
			this.solde -= amount;
		else
			throw new RetraitException("Retrait impossible ! Vous dépasserez le solde minimum autorisé.");
	}

	public void appliquerInteret() {
		solde += this.solde * tauxInteret / 100;
	}

	public float getTauxInteret() {
		return tauxInteret;
	}

}

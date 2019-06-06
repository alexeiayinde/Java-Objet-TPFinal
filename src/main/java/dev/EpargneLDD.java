package dev;

public final class EpargneLDD extends CompteEpargne {

	public EpargneLDD(Proprietaire proprio) {
		super(proprio);
		this.montantMin = 15f;
		this.montantMax = 12000f;
		this.solde = this.montantMin;
		this.tauxInteret = 1f;
	}

}

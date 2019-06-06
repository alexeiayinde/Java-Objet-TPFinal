package dev;

public final class EpargneLEP extends CompteEpargne {

	public EpargneLEP(ProprietairePhysique proprio) {
		super(proprio);
		this.montantMin = 30f;
		this.montantMax = 7700f;
		this.solde = this.montantMin;
		this.tauxInteret = 1.5f;
	}
}

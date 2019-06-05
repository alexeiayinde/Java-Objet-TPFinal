package dev;

public final class EpargneLEP extends CompteEpargne {

	private static double tauxInteret = 1.5;

	public EpargneLEP(Proprietaire proprio) {
		super(proprio);
		this.montantMin = 30;
		this.montantMax = 7700;
		this.solde = this.montantMin;
	}

	@Override
	public void appliquerInterets() {
		solde += solde * EpargneLEP.tauxInteret / 100;
	}

	public static double getTauxInteret() {
		return tauxInteret;
	}

	public static void setTauxInteret(double tauxInteret) {
		EpargneLEP.tauxInteret = tauxInteret;
	}

}

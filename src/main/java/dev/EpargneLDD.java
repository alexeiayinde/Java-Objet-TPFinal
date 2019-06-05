package dev;

public final class EpargneLDD extends CompteEpargne {

	private static double tauxInteret = 1;

	public EpargneLDD(Proprietaire proprio) {
		super(proprio);
		this.montantMin = 15;
		this.montantMax = 12000;
		this.solde = this.montantMin;
	}

	@Override
	public void appliquerInterets() {
		solde += solde * EpargneLDD.tauxInteret / 100;
	}

	public static double getTauxInteret() {
		return tauxInteret;
	}

	public static void setTauxInteret(double tauxInteret) {
		EpargneLDD.tauxInteret = tauxInteret;
	}

}

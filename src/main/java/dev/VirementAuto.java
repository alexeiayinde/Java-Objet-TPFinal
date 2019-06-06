package dev;

public final class VirementAuto {

	private Compte compteDebiteur, compteCrediteur;
	private float montant;

	public VirementAuto(Compte compteDebiteur, Compte compteCrediteur, float montant) {
		this.compteDebiteur = compteDebiteur;
		this.compteCrediteur = compteCrediteur;
		this.montant = montant;
	}

	public Compte getCompteDebiteur() {
		return compteDebiteur;
	}

	public void setCompteDebiteur(Compte compteDebiteur) {
		this.compteDebiteur = compteDebiteur;
	}

	public Compte getCompteCrediteur() {
		return compteCrediteur;
	}

	public void setCompteCrediteur(Compte compteCrediteur) {
		this.compteCrediteur = compteCrediteur;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Virement automatique entre le compte " + compteDebiteur.getNumero() + " (" + compteDebiteur.getProprio()
				+ ") et le compte " + compteCrediteur.getNumero() + " (" + compteCrediteur.getProprio()
				+ ") d'un montant de " + this.montant + "€";
	}

}

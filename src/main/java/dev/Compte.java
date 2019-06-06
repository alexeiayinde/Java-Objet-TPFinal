package dev;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;

public abstract class Compte implements Serializable {

	protected static HashSet<Integer> listeNumero = new HashSet<Integer>();

	protected Proprietaire proprio;
	protected int numero;
	protected float solde;

	public Compte(Proprietaire proprio) {
		this.proprio = proprio;

		do {
			numero = generateRandom(100_000_000, 999_999_999);
		} while (listeNumero.contains(numero));

		listeNumero.add(numero);
		proprio.addCompte(this);
	}

	public Proprietaire getProprio() {
		return proprio;
	}

	public void setProprio(Proprietaire proprio) {
		this.proprio = proprio;
	}

	public int getNumero() {
		return numero;
	}

	public float getSolde() {
		return solde;
	}

	public abstract void verserEspece(float amount) throws VersementException;

	public abstract void retirerEspece(float amount) throws RetraitException;

	public void virement(Compte compteCrediteur, float amount) {
		if (this.getProprio().equals(compteCrediteur.getProprio())) {
			try {
				this.retirerEspece(amount);
				compteCrediteur.verserEspece(amount);
				System.out.println("Virement effectué !");
			} catch (RetraitException | VersementException e) {
			}
		} else {
			try {
				this.retirerEspece(amount + 1);
				compteCrediteur.verserEspece(amount);
				System.out.println("Virement effectué !");
			} catch (RetraitException | VersementException e) {
			}
		}
	}

	@Override
	public String toString() {
		return this.proprio + "\nNuméro de compte : " + this.numero + "\nSolde : " + this.solde + "€";
	}

	public static int generateRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

}

package dev;

import java.util.HashSet;
import java.util.Random;

public abstract class Compte {

	protected static HashSet<Integer> listeNumero = new HashSet<Integer>();

	protected Proprietaire proprio;
	protected int numero;
	protected double solde;

	public Compte(Proprietaire proprio) {
		this.proprio = proprio;

		do {
			numero = generateRandom(100_000_000, 999_999_999);
		} while (listeNumero.contains(numero));

		listeNumero.add(numero);
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

	public double getSolde() {
		return solde;
	}

	public abstract void verserEspece(double amount) throws VersementException;

	public abstract void retirerEspece(double amount) throws RetraitException;

	public void virement(Compte compteCrediteur, double amount) {
		if (this.getProprio().equals(compteCrediteur.getProprio())) {
			try {
				this.retirerEspece(amount);
				compteCrediteur.verserEspece(amount);
			} catch (RetraitException | VersementException e) {
			}
		} else {
			try {
				this.retirerEspece(amount - 1);
				compteCrediteur.verserEspece(amount);
			} catch (RetraitException | VersementException e) {
			}
		}

	}

	public static int generateRandom(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

}

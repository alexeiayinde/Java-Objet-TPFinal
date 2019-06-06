package dev;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Proprietaire implements Serializable {

	protected String nom;
	protected String adresse;
	protected String typeProprietaire;
	protected ArrayList<Compte> listeCompte;

	public Proprietaire(String nom, String adresse) {
		this.nom = nom;
		this.adresse = adresse;
		listeCompte = new ArrayList<Compte>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTypeProprietaire() {
		return typeProprietaire;
	}

	public void setTypeProprietaire(String typeProprietaire) {
		this.typeProprietaire = typeProprietaire;
	}

	public ArrayList<Compte> getListeCompte() {
		return listeCompte;
	}

	public void addCompte(Compte compte) {
		if (!listeCompte.contains(compte)) {
			listeCompte.add(compte);
		} else {
			System.out.println("Ce compte existe déjà dans le fichier client!");
		}
	}

	@Override
	public String toString() {
		return "Nom du propriétaire : " + this.nom + "\nAdresse du propriétaire : " + this.adresse
				+ "\nType de propriétaire : " + this.typeProprietaire;
	}

}

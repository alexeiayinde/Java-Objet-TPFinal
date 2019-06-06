package dev;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public final class Banque {

	private List<Proprietaire> listeProprio;
	private List<Compte> listeCompte;
	private List<VirementAuto> listeVirement;

	public Banque() {
		listeProprio = new ArrayList<Proprietaire>();
		listeCompte = new ArrayList<Compte>();
		listeVirement = new ArrayList<VirementAuto>();
	}

	public List<Proprietaire> getListeProprio() {
		return listeProprio;
	}

	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	public List<VirementAuto> getListeVirement() {
		return listeVirement;
	}

	public void addProprio(Proprietaire proprio) { // En ajoutant un nouveau propriétaire, ses comptes associés sont
													// également ajoutés dans listeCompte
		if (!listeProprio.contains(proprio)) {
			listeProprio.add(proprio);
			for (Compte compte : proprio.getListeCompte()) {
				listeCompte.add(compte);
			}
		} else
			System.out.println("Ce propriétaire existe déjà dans la base de données!");
	}

	public void addCompte(Compte compte) { // Un nouveau compte est ajouté si le propriétaire existe déjà
		if (!listeCompte.contains(compte) && listeProprio.contains(compte.getProprio())) {
			listeCompte.add(compte);
			for (int i = 0; i < listeProprio.size(); i++) {
				if (listeProprio.get(i).equals(compte.getProprio()))
					listeProprio.get(i).addCompte(compte);
			}
		} else
			System.out.println(
					"Ce compte existe déjà dans la base de données/Le propriétaire n'existe pas dans la base de données!");
	}

	public void removeProprio(Proprietaire proprio) {
		if (listeProprio.contains(proprio))
			listeProprio.remove(proprio);
		else
			System.out.println("Le propriétaire à supprimer n'existe pas dans la base de données!");
	}

	public void addVirementAuto(VirementAuto virement) {
		listeVirement.add(virement);
	}

	public void appliquerInterets() {
		for (int i = 0; i < listeCompte.size(); i++) {
			if (listeCompte.get(i) instanceof CompteEpargne) {
				((CompteEpargne) (listeCompte.get(i))).appliquerInterets();
			}
		}
	}

	public void appliquerVirement() {
		for (int i = 0; i < listeVirement.size(); i++) {
			listeVirement.get(i).getCompteDebiteur().virement(listeVirement.get(i).getCompteCrediteur(),
					listeVirement.get(i).getMontant());
		}
	}

	public ArrayList<Proprietaire> searchProprio(String nom) {
		ArrayList<Proprietaire> listeProprios = new ArrayList<Proprietaire>();
		for (Proprietaire proprio : listeProprio) {
			if (proprio.getNom().toUpperCase().indexOf(nom.toUpperCase()) != -1)
				listeProprios.add(proprio);
		}

		if (listeProprios.isEmpty())
			System.out.println("Ce propriétaire n'existe pas dans la base de données!");

		return listeProprios;

	}

	public ArrayList<Compte> getAccounts(Proprietaire proprio) {

		for (Proprietaire prop : listeProprio) {
			if (prop.equals(proprio)) {
				return prop.getListeCompte();
			}
		}
		System.out.println("Ce propriétaire n'existe pas dans la base de données!");
		return null;
	}

	public ArrayList<CompteCourant> comptesDecouvert() {
		ArrayList<CompteCourant> comptesDecouvert = new ArrayList<CompteCourant>();
		for (Compte compte : listeCompte) {
			if (compte instanceof CompteCourant && ((CompteCourant) compte).getSolde() < 0)
				comptesDecouvert.add((CompteCourant) compte);
		}

		if (comptesDecouvert.isEmpty())
			System.out.println("Aucun compte n'est à découvert.");

		return comptesDecouvert;
	}

	public double getSoldeTotal(Proprietaire proprio) {
		double soldeTotal = 0;

		for (Proprietaire prop : listeProprio) {
			if (prop.equals(proprio)) {
				for (Compte compte : prop.getListeCompte())
					soldeTotal += compte.getSolde();
				break;
			}
		}
		return soldeTotal;
	}

	public void sauvegarder() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(new File("Banque.txt"))));
			oos.writeObject(listeProprio);
			oos.writeObject(listeCompte);

			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void restaurer() {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(new File("Banque.txt"))));
			this.listeProprio = (ArrayList<Proprietaire>) ois.readObject();
			this.listeCompte = (ArrayList<Compte>) ois.readObject();

			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

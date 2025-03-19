package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//  Vérifie si l'acheteur est un habitant du village
	public boolean verifierIdentiteAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	// Trouve tous les vendeurs qui vendent un certain produit
	public Gaulois[] rechercherVendeursProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}

	//  Permet à l'acheteur d'acheter une quantité d'un produit chez un vendeur
	public int acheterProduit(String nomVendeur, int quantiteAcheter) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal == null) {
			return -1; //  Vendeur introuvable
		}
		return etal.acheterProduit(quantiteAcheter);
	}
}
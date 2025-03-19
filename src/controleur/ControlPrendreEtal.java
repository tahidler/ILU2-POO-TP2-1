package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite, Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	// ✅ Vérifie s'il reste des étals libres
	public boolean resteEtals() {
		return village.rechercherEtalVide(); // Retourne `true` s'il y a un étal libre
	}

	// ✅ Vérifie si le vendeur existe dans le village
	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}

	// ✅ Attribue un étal au vendeur
	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		Gaulois vendeur = village.trouverHabitant(nomVendeur); // 🔍 Trouver l'objet Gaulois
		if (vendeur == null) {
			return -1; // Aucun habitant trouvé avec ce nom
		}
		int numeroEtal = village.installerVendeur(vendeur, produit, nbProduit);
		return (numeroEtal == -1) ? -1 : numeroEtal + 1; // ✅ Décalage pour que l’étal commence à 1
	}
}
package controleur;

import villagegaulois.Village;

public class ControlVerifierIdentite {
	private Village village;

	public ControlVerifierIdentite(Village village) {
		this.village = village;
	}

	public boolean verifierIdentite(String nomVendeur) {
		// Vérifie si le vendeur existe dans le village
		return village.trouverHabitant(nomVendeur) != null;
	}
}
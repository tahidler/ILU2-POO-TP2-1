package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Gaulois;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		//  Trouver l'habitant dans le village
		Gaulois vendeur = village.trouverHabitant(nomVendeur);

		// 📌 2️⃣ Vérifier si l'habitant existe
		if (vendeur == null) {
			return null; // Aucun étal trouvé si le vendeur n'existe pas
		}

		// Rechercher l'étal du vendeur et le retourner
		return village.rechercherEtal(vendeur);
	}
}
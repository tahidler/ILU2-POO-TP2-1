package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] libererEtal(String nomVendeur) {
		// Trouve l'étal du vendeur
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal == null) {
			return null;
		}

		// Récupère les informations de l’étal avant de le libérer
		String nomProduit = etal.getProduit();
		int quantiteDebut = etal.getQuantiteDebutMarche();
		int quantiteVendue = quantiteDebut - etal.getQuantite();
		etal.libererEtal();

		
		return new String[] {
			"true",
			nomVendeur,
			nomProduit,
			String.valueOf(quantiteDebut),
			String.valueOf(quantiteVendue)
		};
	}
}
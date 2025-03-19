package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	//Méthode pour récupérer l'état du marché
	public String[] donnerInfosMarche() {
		return village.donnerEtatMarche(); 
	}
}
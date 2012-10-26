
package com.objet.lofteurs;

public class Saison1 {

	public static int nombreLofteurs = 4;
	public static int tailleLoft = 30; //dimension d'un côté du carré

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Saison1().primeTime();
	}
	
	public void primeTime() {
		ZoneGraphique zone = new ZoneGraphique("Mon premier loft");
		Loft loft = new Loft(tailleLoft,zone);
		
                zone.ajouterObjet(loft);
                loft.remplissageAleatoire(11); //s'il vous plaît choisir une valeur positive plus grand que 10              
                loft.ajouterNeuneusAleatoire(101);

                
		loft.go( zone.getGraphics() );
	}

}

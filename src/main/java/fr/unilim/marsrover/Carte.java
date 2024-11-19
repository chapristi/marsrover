package fr.unilim.marsrover;

import java.util.Optional;

public class Carte {
	
	private final Case[][] cases = new Case[ProprietesCarte.TAILLE_CARTE][ProprietesCarte.TAILLE_CARTE];    

    public Carte() {
        for (int x = 0; x < ProprietesCarte.TAILLE_CARTE; x++) {
            for (int y = 0; y < ProprietesCarte.TAILLE_CARTE; y++) {
                cases[x][y] = new Case(Optional.empty());
            }
        }
    }
    
   public boolean aObjetPosition(Coordonnees coordonnees) 
   {
	   return cases[coordonnees.getX()][coordonnees.getY()].aObjet();
   }
    
}

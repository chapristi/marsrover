package fr.unilim.marsrover;

import fr.unilim.marsrover.etat.EtatDirection;
import fr.unilim.marsrover.etat.EtatNord;

public class Rover implements Robot{

	private Coordonnees coordonnees;
	private Carte carte;
	private EtatDirection etatDirection;
   
	
	public Rover(Carte carte) {
		this.coordonnees = new Coordonnees(0,0);
		this.etatDirection = new EtatNord();
		this.carte = carte;
	}
	
	public int getCoordonneesX() {
		return coordonnees.getX();
	}
	
	public int getCoordonneesY() {
		return coordonnees.getY();
	}
	
	public Coordonnees setCoordonnees(Coordonnees coordonnees)  {
		this.coordonnees = coordonnees ;
		return this.coordonnees;
	}
	
	public Carte getCarte() {
		return this.carte;
	}

	public void tournerGauche() {
        etatDirection.tournerGauche(this);
    }

    public void tournerDroite() {
        etatDirection.tournerDroite(this);
    }

    public void avancer() throws ObstacleRencontreException {
        etatDirection.avancer(this);
    }

    public void reculer() throws ObstacleRencontreException {
        etatDirection.reculer(this);
    }

	public void setEtat(EtatDirection etat) {
		this.etatDirection = etat;
		
	}

	public void executeCommands(String commands) throws ObstacleRencontreException {
	     for (char command : commands.toCharArray()) {
	    		 switch (command) {
	    		        case 'f' -> this.avancer();
	    		        case 'b' -> this.reculer();
	    		        case 'l' -> this.tournerGauche();
	    		        case 'r' -> this.tournerDroite();
	    		        default -> throw new IllegalArgumentException("Commande invalide : " + command);
	    		 }
	    	}
	  }

	
	   
}

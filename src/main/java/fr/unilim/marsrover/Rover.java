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

	
	    public void executeCommands(String commands) {
	        for (char command : commands.toCharArray()) {
	            switch (command) {
	                case 'f':
	                    try {
	                        this.avancer();
	                    } catch (ObstacleRencontreException e) {
	                        System.out.println("Commande interrompue : " + e.getMessage());
	                        return; 
	                    }
	                    break;
	                case 'b':
	                    try {
	                        this.reculer();
	                    } catch (ObstacleRencontreException e) {
	                        System.out.println("Commande interrompue : " + e.getMessage());
	                        return;
	                    }
	                    break;
	                case 'l':
	                	 this.tournerGauche();
	                    break;
	                case 'r':
	                	 this.tournerDroite();
	                    break;
	                default:
	                    System.out.println("Commande invalide : " + command);
	                    break;
	            }
	  
	        }
	  }

	
	   
}

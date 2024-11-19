package fr.unilim.marsrover;

public class Rover implements Robot{

	private Coordonnees coordonnees;
	private DIRECTION direction;
	private Carte carte;
   
	
	public Rover(Carte carte) {
		this.coordonnees = new Coordonnees(0,0);
		this.direction = DIRECTION.NORD;
		this.carte = carte;
	}
	
	public int getCoordonneesX() {
		return coordonnees.getX();
	}
	
	public int getCoordonneesY() {
		return coordonnees.getY();
	}

	public DIRECTION getDirection() {
		return direction;
	}

	 public void avancer() throws ObstacleRencontreException {
		 int nouveauX = coordonnees.getX();
		 int nouveauY = coordonnees.getY();
		 switch (this.direction) {
		 	case NORD:
	                nouveauY = (nouveauY + 1) % ProprietesCarte.TAILLE_CARTE;
	                break;
	        case SUD:
	                nouveauY = (nouveauY - 1 + ProprietesCarte.TAILLE_CARTE) % ProprietesCarte.TAILLE_CARTE;
	                break;
	        case EST:
	                nouveauX = (nouveauX + 1) % ProprietesCarte.TAILLE_CARTE;
	                break;
	        case OUEST:
	                nouveauX = (nouveauX - 1 + ProprietesCarte.TAILLE_CARTE) % ProprietesCarte.TAILLE_CARTE;
	                break;
	        }
		 	if (this.carte.aObjetPosition(new Coordonnees(nouveauX, nouveauY))) {
		 		throw new ObstacleRencontreException("je ne peux pas reculer il y a un objet devant mois");
		 	}
		 	
	        this.coordonnees = new Coordonnees(nouveauX, nouveauY);
	    }

	    public void reculer() throws ObstacleRencontreException {
	        int nouveauX = coordonnees.getX();
	        int nouveauY = coordonnees.getY();

	        switch (this.direction) {
	            case NORD:
	                nouveauY = (nouveauY - 1 + ProprietesCarte.TAILLE_CARTE) % ProprietesCarte.TAILLE_CARTE;
	                break;
	            case SUD:
	                nouveauY = (nouveauY + 1) % ProprietesCarte.TAILLE_CARTE;
	                break;
	            case EST:
	                nouveauX = (nouveauX - 1 + ProprietesCarte.TAILLE_CARTE) % ProprietesCarte.TAILLE_CARTE;
	                break;
	            case OUEST:
	                nouveauX = (nouveauX + 1) % ProprietesCarte.TAILLE_CARTE;
	                break;
	        }
	     	if (this.carte.aObjetPosition(new Coordonnees(nouveauX, nouveauY))) {
		 		throw new ObstacleRencontreException("je ne peux pas reculer il y a un objet derrière mois");
		 	}
	        this.coordonnees = new Coordonnees(nouveauX, nouveauY);
	    }
	    
	
	public void tournerGauche() {
	   switch (this.direction) {
	      case NORD:
	           this.direction = DIRECTION.OUEST;
	           break;
	            
	        case EST:
	            this.direction = DIRECTION.NORD;
	            break;

	        case SUD:
	            this.direction = DIRECTION.EST;
	            break;
	            
	        case OUEST:
	            this.direction = DIRECTION.SUD;
	            break;
	        default:
	            break;
	        }
	    }
	    
	    public void tournerDroite() {
	        switch (this.direction) {
	        case NORD:
	            this.direction = DIRECTION.EST;
	            break;
	            
	        case EST:
	            this.direction = DIRECTION.SUD;
	            break;

	        case SUD:
	            this.direction = DIRECTION.OUEST;
	            break;
	            
	        case OUEST:
	            this.direction = DIRECTION.NORD;
	            break;
	        }
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

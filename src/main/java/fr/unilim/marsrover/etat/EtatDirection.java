package fr.unilim.marsrover.etat;

import fr.unilim.marsrover.ObstacleRencontreException;
import fr.unilim.marsrover.Rover;

public interface EtatDirection {

	void avancer(Rover rover) throws ObstacleRencontreException;
    void reculer(Rover rover) throws ObstacleRencontreException;
    void tournerGauche(Rover rover);
    void tournerDroite(Rover rover);
}

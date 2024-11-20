package fr.unilim.marsrover.etat;

import fr.unilim.marsrover.*;

public class EtatSud implements EtatDirection {

    @Override
    public void tournerGauche(Rover rover) {
        rover.setEtat(new EtatEst());
    }

    @Override
    public void tournerDroite(Rover rover) {
        rover.setEtat(new EtatOuest());
    }

    @Override
    public void avancer(Rover rover) throws ObstacleRencontreException {
        int nouveauY = (rover.getCoordonneesY() - 1 + ProprietesCarte.TAILLE_CARTE) % ProprietesCarte.TAILLE_CARTE;
        if (rover.getCarte().aObjetPosition(new Coordonnees(rover.getCoordonneesX(), nouveauY))) {
            throw new ObstacleRencontreException("Obstacle détecté devant, impossible d'avancer !");
        }
        rover.setCoordonnees(new Coordonnees(rover.getCoordonneesX(), nouveauY));
    }

    @Override
    public void reculer(Rover rover) throws ObstacleRencontreException {
        int nouveauY = (rover.getCoordonneesY() + 1) % ProprietesCarte.TAILLE_CARTE;
        if (rover.getCarte().aObjetPosition(new Coordonnees(rover.getCoordonneesX(), nouveauY))) {
            throw new ObstacleRencontreException("Obstacle détecté derrière, impossible de reculer !");
        }
        rover.setCoordonnees(new Coordonnees(rover.getCoordonneesX(), nouveauY));
    }
}

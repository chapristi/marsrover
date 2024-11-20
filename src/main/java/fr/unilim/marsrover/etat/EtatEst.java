package fr.unilim.marsrover.etat;

import fr.unilim.marsrover.*;

public class EtatEst implements EtatDirection {

    @Override
    public void tournerGauche(Rover rover) {
        rover.setEtat(new EtatNord());
    }

    @Override
    public void tournerDroite(Rover rover) {
        rover.setEtat(new EtatSud());
    }

    @Override
    public void avancer(Rover rover) throws ObstacleRencontreException {
        int nouveauX = (rover.getCoordonneesX() + 1) % ProprietesCarte.TAILLE_CARTE;
        if (rover.getCarte().aObjetPosition(new Coordonnees(nouveauX, rover.getCoordonneesY()))) {
            throw new ObstacleRencontreException("Obstacle détecté devant, impossible d'avancer !");
        }
        rover.setCoordonnees(new Coordonnees(nouveauX, rover.getCoordonneesY()));
    }

    @Override
    public void reculer(Rover rover) throws ObstacleRencontreException {
        int nouveauX = (rover.getCoordonneesX() - 1 + ProprietesCarte.TAILLE_CARTE) % ProprietesCarte.TAILLE_CARTE;
        if (rover.getCarte().aObjetPosition(new Coordonnees(nouveauX, rover.getCoordonneesY()))) {
            throw new ObstacleRencontreException("Obstacle détecté derrière, impossible de reculer !");
        }
        rover.setCoordonnees(new Coordonnees(nouveauX, rover.getCoordonneesY()));
    }
}

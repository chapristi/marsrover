package fr.unilim.marsrover;

import java.util.Optional;

public class Case {
	
	private Optional<Obstacle> obstacle;
	
	public Case(Optional<Obstacle> obstacles) {
		this.obstacle = obstacles;
	}
	
	public Optional<Obstacle> getObstacle(){
		return this.obstacle;
	}
	
	public boolean aObjet() {
        return this.obstacle.isPresent();
    }
}

package fr.unilim.marsrover;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RoverTest {

    private Rover rover;
    private Carte carte;
    
    @Mock
    private Carte mockCarte;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        carte = mock(Carte.class);
        rover = new Rover(carte);
    }
    
    @Test
    void testInitialisation() {
    	   assertEquals(0, rover.getCoordonneesX());
           assertEquals(0, rover.getCoordonneesY());
    }

    @Test
    void testAvancer() throws ObstacleRencontreException {
        when(carte.aObjetPosition(new Coordonnees(0, 1))).thenReturn(false);

        rover.avancer();

        assertEquals(0, rover.getCoordonneesX());
        assertEquals(1, rover.getCoordonneesY());
    }

    @Test
    void testAvancerAvecObstacle() {
        when(carte.aObjetPosition(new Coordonnees(0, 1))).thenReturn(true);

        assertThrows(ObstacleRencontreException.class, () -> rover.avancer());
    }

    @Test
    void testReculer() throws ObstacleRencontreException {

        rover.reculer();

        assertEquals(0, rover.getCoordonneesX());
        assertEquals(99, rover.getCoordonneesY());
    }

    @Test
    void testReculerAvecObstacle() {
        when(carte.aObjetPosition(new Coordonnees(0, 99))).thenReturn(true);

        assertThrows(ObstacleRencontreException.class, () -> rover.reculer());
    }

    @Test
    void testExecuteCommands() throws ObstacleRencontreException {
        when(carte.aObjetPosition(any(Coordonnees.class))).thenReturn(false);

        rover.executeCommands("ffrff");

        assertEquals(2, rover.getCoordonneesX());
        assertEquals(2, rover.getCoordonneesY());
    }
}

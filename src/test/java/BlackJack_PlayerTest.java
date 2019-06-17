import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlackJack_PlayerTest {
    BlackJack_Player player1;

    @Before
    public void setUp() throws Exception {
        BlackJack_Player player1 = new BlackJack_Player(new Person(1000.00,"Stefun", 34));
        BlackJack_Player [] players = new BlackJack_Player[3];
        players[0] = player1;
        BlackJack blackJack1 = new BlackJack(players, 5);

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void split() {
    }

    @Test
    public void hitOrStay() {
    }

    @Test
    public void doubleDown() {
    }

    @Test
    public void bet() {
    }
}
package io.zipcoder.casino.Games;

import io.zipcoder.casino.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    @Test
    public void runGame() {

        Craps craps = new Craps();
        craps.runGame(new Player("Test", 500));

    }
}
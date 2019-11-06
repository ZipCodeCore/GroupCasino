package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoFishTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void game() {

        GoFish newgame = new GoFish(new Player("John", "007"));

        newgame.startGame();

    }

}
package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import org.junit.Test;

public class BeetleGameTest {
    @Test
    public void testGameOver(){
        BeetleGame game = new BeetleGame();
        Boolean isGameOver = game.getIsRunning();
    }
}

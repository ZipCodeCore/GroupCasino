package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import org.junit.Test;

public class BlackJackGameTest {

    @Test
    public void runTest () {
        BlackJackGame bj = new BlackJackGame();

        Integer userInput = 1;
        bj.run();
    }
}

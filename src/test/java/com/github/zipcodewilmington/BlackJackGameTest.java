package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import org.junit.Test;

public class BlackJackGameTest {

    @Test
    public void runTest () {
        Player player = new Player("Roger", 5000);
        BlackJackGame bj = new BlackJackGame();

        Integer userInput = 1;
        bj.run();

    }
}

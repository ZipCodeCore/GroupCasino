package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BlackJackGameTest {

    @Test
    public void runTest () {
        Player player = new Player("Roger", 5000);
        BlackJackGame bj = new BlackJackGame();

        Integer userInput = 1;
        bj.run();

    }

    @Test
    public void splitPlayer () {
        BlackJackGame bjg = new BlackJackGame();
        BlackJack bj = new BlackJack();

        List<Integer> input = Arrays.asList(10, 10);
        bj.setPlayersHand(input);
        System.out.println(bj.getPlayersHand());
        System.out.println(bj.playersCurrentValue());


        bjg.splitPlayer();

    }
}

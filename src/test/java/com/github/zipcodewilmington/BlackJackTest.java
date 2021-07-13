package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BlackJackTest {
    @Test
    public void generateNewDeckTest() {
        BlackJack bj = new BlackJack();
        Integer expected = 165;

        Integer actual1 = bj.generateNewDeck(52).size();
        List<Integer> actual = bj.generateNewDeck(52);
        System.out.println(actual);

        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void givePlayerCardTest() {
        BlackJack bj = new BlackJack();
        Integer expected = 2;

        bj.givePlayerCard();
        bj.givePlayerCard();
        Integer actual = bj.getPlayersHand().size();

        System.out.println(bj.getPlayersHand());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playersCurrentValueTest () {
        BlackJack bj = new BlackJack();
        // Solid stopping point = need to populate array for test
        bj.givePlayerCard();
        bj.givePlayerCard();
        System.out.println(bj.playersCurrentValue());
    }
}

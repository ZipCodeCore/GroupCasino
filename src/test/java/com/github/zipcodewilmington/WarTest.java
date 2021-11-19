package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardGames.War;
import org.junit.Assert;
import org.junit.Test;

public class WarTest {

    @Test
    public void testRules() {
        //given
        War war = new War();
        String expected = "Welcome to the game of War.\n\nEach player will get dealt a " +
                "card. Whoever has the higher \nvalue card wins that round, and gets awarded " +
                "one point. In \nthe event of a tie, no points will be rewarded and both " +
                "\nplayers will play again. The winner is the first player to \nscore ten points.\n";

        //when
        String actual = war.warRules();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEnterNames() {
        //given
        War war = new War();
        String expected = "Computer";

        //when
        String actual = war.enterNames();

        //then
        Assert.assertEquals(expected, actual);
    }


}

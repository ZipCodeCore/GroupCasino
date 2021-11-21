package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.cardGames.*;
import org.junit.Assert;
import org.junit.Test;

public class WarTest {

    @Test
    public void testRules() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("john", "ellis", 1000.0);
        War war = new War(casinoAccount);
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
    public void testDetermineGameWinnerPlayer1() {
        //given
        int player1Score = 10;
        int player2Score = 5;
        CasinoAccount casinoAccount = new CasinoAccount("john", "ellis", 1000.0);
        War war = new War(casinoAccount);
        war.enterNames("John");
        String expected = "\n" + "John" + " has won the game!\n";

        //when
        String actual = war.determineGameWinner(player1Score, player2Score);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineGameWinnerPlayer2() {
        //given
        int player1Score = 5;
        int player2Score = 10;
        CasinoAccount casinoAccount = new CasinoAccount("john", "ellis", 1000.0);
        War war = new War(casinoAccount);
        war.enterNames("Computer");
        String expected = "\n" + "Computer" + " has won the game!\n";

        //when
        String actual = war.determineGameWinner(player1Score, player2Score);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineRoundWinnerPlayer1() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("john", "ellis", 1000.0);
        War war = new War(casinoAccount);
        Cards player1Card = new Cards(Suit.SPADES, Rank.FIVE);
        Cards player2Card = new Cards(Suit.SPADES, Rank.TWO);

        war.enterNames("John");
        String expected = "\n" + "John" + " has won this round!";

        //when
        String actual = war.determineRoundWinner(player1Card, player2Card);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineRoundWinnerPlayer2() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("john", "ellis", 1000.0);
        War war = new War(casinoAccount);
        Cards player1Card = new Cards(Suit.SPADES, Rank.FIVE);
        Cards player2Card = new Cards(Suit.SPADES, Rank.NINE);
        war.enterNames("John");
        String expected = "\n" + "Computer" + " has won this round!";

        //when
        String actual = war.determineRoundWinner(player1Card, player2Card);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineRoundWinnerTie() {
        //given
        CasinoAccount casinoAccount = new CasinoAccount("john", "ellis", 1000.0);
        War war = new War(casinoAccount);
        Cards player1Card = new Cards(Suit.SPADES, Rank.FIVE);
        Cards player2Card = new Cards(Suit.SPADES, Rank.FIVE);
        war.enterNames("Computer");
        String expected = "\nIt was a tie.\n";

        //when
        String actual = war.determineRoundWinner(player1Card, player2Card);

        //then
        Assert.assertEquals(expected, actual);
    }


}

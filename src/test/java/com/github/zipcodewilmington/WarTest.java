package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardGames.Cards;
import com.github.zipcodewilmington.casino.games.cardGames.Rank;
import com.github.zipcodewilmington.casino.games.cardGames.War;
import com.github.zipcodewilmington.casino.games.cardGames.createDeck;
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
    public void testDetermineGameWinnerPlayer1() {
        //given
        int player1Score = 10;
        int player2Score = 5;
        War war = new War();
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
        War war = new War();
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
        War war = new War();
        Rank player1CardRank = Rank.SIX;
        Rank player2CardRank = Rank.FOUR;
        war.enterNames("John");
        String expected = "\n" + "John" + " has won this round!";

        //when
        String actual = war.determineRoundWinner(player1CardRank, player2CardRank);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineRoundWinnerPlayer2() {
        //given
        War war = new War();
        Rank player1CardRank = Rank.FIVE;
        Rank player2CardRank = Rank.NINE;
        war.enterNames("John");
        String expected = "\n" + "Computer" + " has won this round!";

        //when
        String actual = war.determineRoundWinner(player1CardRank, player2CardRank);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineRoundWinnerTie() {
        //given
        War war = new War();
        Rank player1CardRank = Rank.SIX;
        Rank player2CardRank = Rank.SIX;
        war.enterNames("Computer");
        String expected = "\nIt was a tie.\n";

        //when
        String actual = war.determineRoundWinner(player1CardRank, player2CardRank);

        //then
        Assert.assertEquals(expected, actual);
    }


}

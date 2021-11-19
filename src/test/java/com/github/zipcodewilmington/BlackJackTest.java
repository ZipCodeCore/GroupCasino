package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.cardGames.BlackJack;
import com.github.zipcodewilmington.casino.games.cardGames.War;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackTest {
    @Test
    public void testRules() {
        //given
        BlackJack blackJack = new BlackJack();
        String expected = "Blackjack is played with one or more standard 52-card decks, with each denomination assigned a\n " +
                "point value. The cards 2 through 10 are worth their face value. Kings, queens, and jacks are each\n" +
                " worth 10, and aces may be used as either 1 or 11. The object for the player is to draw cards\n" +
                " totaling closer to 21, without going over, than the dealer's cards.";

        //when
        String actual = blackJack.rules();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinnerTest1() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 0;
        Integer totalDealerValue = 22;
        String expected = "You are the winner!";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinnerTest2() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    /*@Test
    public void dealerActionTest1() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalDealerValue = 15;
        String expected = "The dealer drew a " + dealer + ".";

        //when
        String actual = blackJack.dealerAction(totalDealerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerActionTest2() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalDealerValue = 18;
        String expected = "The dealer has a " + dealer + ".";

        //when
        String actual = blackJack.dealerAction(totalDealerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking1() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking2() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking3() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking4() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking5() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void valueChecking6() {
        //given
        BlackJack blackJack = new BlackJack();
        Integer totalPlayerValue = 22;
        Integer totalDealerValue = 0;
        String expected = "The dealer won this game.";

        //when
        String actual = blackJack.checkWinner(totalDealerValue, totalPlayerValue);

        //then
        Assert.assertEquals(expected, actual);
    }*/
}

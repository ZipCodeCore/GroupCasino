package io.zipcoder.casino.games;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import io.zipcoder.casino.Handler;
import io.zipcoder.casino.player.Player;

public class BlackjackTest {

    @Test
    public void stayTest() {

    }

    @Test
    public void splitTest() {

    }

    @Test
    public void doubleDownTest() {

    }

    @Test
    public void getPlayer1ScoreTest() {

    }

    @Test
    public void setPlayer1ScoreTest() {

    }

    @Test
    public void getPlayer2ScoreTest() {

    }

    @Test
    public void setPlayer2ScoreTest() {

    }

    @Test
    public void nextTurnTest() {

    }

    @Test
    public void endGameTest() {
        Handler handler = new Handler();
        Player player = handler.createPlayer("Sally", 200.0);
        Blackjack blackjack = new Blackjack();


        Boolean expected = false;
        Boolean actual = player.getPlaying();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void calcBJPaymentTest() {
        Blackjack blackjack = new Blackjack();

        blackjack.setOdds(3.0);
        blackjack.setCurrentBet(10.0);

        Double expected = 30.0;
        Double actual = blackjack.calcPayment(blackjack.odds, blackjack.getCurrentBet());

        Assert.assertEquals(expected, actual);
    }
}


   /* @Test
>>>>>>> modified:src/test/java/io/zipcoder/casino/games/BlackjackTest.java
    public void updateAccount(){
        Blackjack blackjack = new Blackjack();

        blackjack.getBlackJackPlayer().setAccount(30.0);
        Double expected = 30.0;
        Double actual = blackjack.getBlackJackPlayer().getAccount();

        Assert.assertEquals(expected, actual);
<<<<<<< HEAD:src/test/io/zipcoder/casino/games/BlackjackTest.java
    }
} */

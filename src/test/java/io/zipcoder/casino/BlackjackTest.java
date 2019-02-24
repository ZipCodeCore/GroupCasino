package io.zipcoder.casino;
import io.zipcoder.casino.CardGame.BlackJack.Blackjack;
import org.junit.Assert;
import org.junit.Test;

public class BlackjackTest {
    private Blackjack test = new Blackjack();


    @Test
    public void takeBetTest() {
        //GIVEN
        double stash = test.getPot();

        //WHEN
        test.takeBet(10);

        //THEN
        Assert.assertEquals(test.getPot(),stash + 10,0);

    }

    @Test
    public void payout() {
    }

    @Test
    public void play() {
    }

    @Test
    public void walkAway() {
    }
}
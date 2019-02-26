package io.zipcoder.casino;
import io.zipcoder.casino.CardGame.BlackJack.Blackjack;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackjackTest {

    private Player player;

    @Before
    public void setUp(){
        player = new Player("name", 1000);
    }
    @Test
    public void constructorTest(){
        //Given
        Blackjack blackjack = new Blackjack(player);

        //When

        //Then
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

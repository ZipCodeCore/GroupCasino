import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {

    @Test
    public void pokerHandSizeTest() {
        PokerHand pokerHand = new PokerHand();
        Assert.assertEquals(2, pokerHand.numOfCardInHand());
    }

    @Test
    public void pokerHandSizeTest() {
        PokerHand pokerHand = new PokerHand();
        Assert.assertEquals(2, pokerHand.numOfCardInHand());
    }

    @Test
    public void pokerUniqueTest() {
        // assuming only 1 deck
        PokerHand pokerHand = new PokerHand();
        Assert.assertnotEquals(pokerHand.getCards().get(0),pokerHand.getCards().get(1));
    }
}
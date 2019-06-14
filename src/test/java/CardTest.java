
import org.junit.Test;


import org.junit.Assert;

public class CardTest {


    @Test
    public void flipTest1() {
        Integer faceDown = -1;
        Card card = new Card(faceDown, Rank.ACE, Suit.DIAMOND);
        card.flip();
        Integer expected = 14;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void flipTest2() {
        Integer faceDown = 1;
        Card card = new Card(faceDown, Rank.ACE, Suit.DIAMOND);
        card.flip();
        Integer expected = 14;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest1() {
        Integer faceDown = 1;
        Card card = new Card(faceDown, Rank.SIX, Suit.HEART);

        Integer expected = 14;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest2() {
        Integer faceDown = -1;
        Card card = new Card(faceDown, Rank.JACK, Suit.SPADE);

        Integer expected = 14;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getValueTest3() {
        Integer faceDown = 1;
        Card card = new Card(faceDown, Rank.KING, Suit.CLUB);

        Integer expected = 14;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }
}

import org.junit.Test;


import org.junit.Assert;

public class CardTest {


    @Test
    public void flipTest1() {
        Boolean faceDown = false;
        Card card = new Card(faceDown, Card.Rank.ACE, Card.Suit.DIAMOND);
        card.flip();
        String expected = "P";
        String actual = card.getValue();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void flipTest2() {
        Boolean faceDown = true;
        Card card = new Card(faceDown, Card.Rank.ACE, Card.Suit.DIAMOND);
        card.flip();
        String expected = "ACE_DIAMONDS";
        String actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest1() {
        Boolean faceDown = false;
        Card card = new Card(faceDown, Card.Rank.SIX, Card.Suit.HEART);
        String expected = "SIX_HEARTS";
        String actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest2() {
        Boolean faceDown = false;
        Card card = new Card(faceDown, Card.Rank.JACK, Card.Suit.SPADE);
        String expected = "JACK_SPADES";
        String actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getValueTest3() {
        Boolean faceDown = false;
        Card card = new Card(faceDown, Card.Rank.KING, Card.Suit.CLUB);
        String expected = "KING_CLUBS";
        String actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }
}
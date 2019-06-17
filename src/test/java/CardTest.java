
import org.junit.Test;


import org.junit.Assert;

public class CardTest {


    @Test
    public void flipTest1() {
        Integer faceDownToEveryone = -1;
        Card card = new Card(faceDownToEveryone, Rank.ACE, Suit.DIAMOND);
        card.flip();
        Integer expected = 1;
        Integer actual = card.getValue();
        Assert.assertTrue(card.isFaceUpToEveryone());
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void flipTest2() {
        Integer faceDown = 1;
        Card card = new Card(faceDown, Rank.ACE, Suit.DIAMOND);
        card.flip();
        Integer expected = 1;
        Integer actual = card.getRankNumber();
        Assert.assertTrue(card.isFaceDownToEveryone());
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void flipTest3() {
        Integer faceDown = 0;
        Card card = new Card(faceDown, Rank.ACE, Suit.DIAMOND);
        card.flip();
        Integer expected = 1;
        Integer actual = card.getRankNumber();
        Assert.assertTrue(card.isFaceUpToEveryone());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest1() {
        Integer faceUp = 1;
        Card card = new Card(faceUp, Rank.SIX, Suit.HEART);

        Integer expected = 6;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getValueTest2() {
        Integer faceDown = -1;
        Card card = new Card(faceDown, Rank.JACK, Suit.SPADE);

        Integer expected = 0;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getValueTest3() {
        Integer faceUpToMe = 0;
        Card card = new Card(faceUpToMe, Rank.KING, Suit.CLUB);

        Integer expected = 0;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getValueTest4() {
        Integer faceUp = 1;
        Card card = new Card(faceUp, Rank.QUEEN, Suit.HEART);

        Integer expected = 12;
        Integer actual = card.getValue();
        Assert.assertEquals(expected, actual);
    }
}
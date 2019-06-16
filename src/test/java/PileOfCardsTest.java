import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PileOfCardsTest {

    @Test
    public void clearTest() {
    PileOfCards pile = new PileOfCards();
    ArrayList<Card> cards = new ArrayList<>(5);
    cards.add(new Card(-1, Rank.ACE, Suit.CLUB));
    cards.add(new Card(-1, Rank.TWO, Suit.CLUB));
    cards.add(new Card(-1, Rank.THREE, Suit.CLUB));
    pile.addAll(cards);
    }

    @Test
    public void addAllTest() {
        PileOfCards pile = new PileOfCards();
        ArrayList<Card> cards = new ArrayList<>(5);
        cards.add(new Card(-1, Rank.ACE, Suit.CLUB));
        cards.add(new Card(-1, Rank.TWO, Suit.CLUB));
        cards.add(new Card(-1, Rank.THREE, Suit.CLUB));
        pile.addAll(cards);
        assertFalse(pile.getCards().empty());
    }

    @Test
    public void addTest() {
        PileOfCards pile = new PileOfCards();
        ArrayList<Card> cards = new ArrayList<>(5);
        pile.add(new Card(-1, Rank.JACK, Suit.DIAMOND));
        assertFalse(pile.getCards().empty());
    }

    @Test
    public void removeTest1() {
        PileOfCards pile = new PileOfCards();
        Card card = new Card(-1, Rank.JACK, Suit.DIAMOND);
        pile.add(card);
        assertNotNull(pile.remove());
        assertTrue(pile.getCards().empty());
    }
    @Test
    public void removeTest2() {
        PileOfCards pile = new PileOfCards();
        ArrayList<Card> cards = new ArrayList<>(5);
        cards.add(new Card(-1, Rank.ACE, Suit.CLUB));
        cards.add(new Card(-1, Rank.TWO, Suit.CLUB));
        cards.add(new Card(-1, Rank.THREE, Suit.CLUB));
        pile.addAll(cards);
        assertFalse(pile.getCards().empty());
        pile.remove();
        pile.remove();
        pile.remove();
        assertTrue(pile.getCards().empty());
    }
    @Test
    public void removeTest3() {
        PileOfCards pile = new PileOfCards();
        Card card = new Card(-1, Rank.JACK, Suit.DIAMOND);
        pile.add(card);
        pile.remove();
        assertNull(pile.remove());
        assertTrue(pile.getCards().empty());
    }
}
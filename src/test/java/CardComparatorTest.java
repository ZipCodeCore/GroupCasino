import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardComparatorTest {

    @Test
    public void sortTest() {
        ArrayList<Card> cards = new ArrayList<>();
        CardComparator comp = new CardComparator();
        cards.add(new Card(1,Rank.ACE,Suit.SPADE));
        cards.add(new Card(1,Rank.SIX,Suit.SPADE));
        cards.add(new Card(1,Rank.TWO,Suit.SPADE));
        cards.add(new Card(1,Rank.KING,Suit.SPADE));
        cards.add(new Card(1,Rank.QUEEN,Suit.SPADE));

        cards.sort(comp);
        System.out.println(cards);


    }
}
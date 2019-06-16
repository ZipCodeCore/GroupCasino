import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardComparatorTest {

    @Test
    public void sortTest() {
        ArrayList<Card> cards = new ArrayList<>();
        CardComparator comp = new CardComparator();
        cards.add(new Card(1,Rank.ACE,Suit.DIAMOND));
        cards.add(new Card(1,Rank.ACE,Suit.SPADE));
        cards.add(new Card(1,Rank.SIX,Suit.HEART));
        cards.add(new Card(1,Rank.SIX,Suit.SPADE));
        cards.add(new Card(1,Rank.SIX,Suit.DIAMOND));
        cards.add(new Card(1,Rank.SIX,Suit.CLUB));

        cards.sort(comp);
        System.out.println(cards);


    }
}
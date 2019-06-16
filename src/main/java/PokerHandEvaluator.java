import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHandEvaluator {

 //   ROYAL_FLUSH     (1),
 //   STRAIGHT_FLUSH  (2),
 //   FOUR_OF_A_KIND  (3),
 //   FULL_HOUSE      (4),
 //   FLUSH           (5), good
 //   STRAIGHT        (6),
 //   THREE_OF_A_KIND (7),
 //   TWO_PAIR        (8),
 //   PAIR            (9),
 //   HIGH_CARD       (10);



    public static Boolean isFlush(ArrayList<Card> cards)
    {
            for (Suit suit : Suit.values()){
                Integer suitCount = 0;

                for (Card card: cards)
                    if (card.getSuit() == suit)
                        suitCount++;

                if (suitCount >= 5) return true;
            }
        return false;
    }

    public static Boolean isStraight(ArrayList<Card> cards) {
        cards.sort(new CardComparator());

        for(Integer i = 0; i < cards.size(); i++)
        {
            Integer count = 0;
            Integer currentRankNumber = cards.get(i).getRankNumber();
            
            for (Integer j = i; j < cards.size(); j++) {
                if (cards.get(j).getRankNumber() == currentRankNumber + 1)
                {
                    count++;
                    currentRankNumber++;
                }
                if (count >= 5)
                    return true;
            }
        }
        return false;
    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHandEvaluator {

 //   STRAIGHT_FLUSH  (2), good
 //   FOUR_OF_A_KIND  (3), good
 //   FULL_HOUSE      (4), good
 //   FLUSH           (5), good
 //   STRAIGHT        (6), good
 //   THREE_OF_A_KIND (7), good
 //   TWO_PAIR        (8), good
 //   PAIR            (9), good

//        public static Boolean isStraightFlush(ArrayList<Card> cards) {
//        return isFlush(getStrightCard(cards));
//    }

    public static Boolean isFourOfAKind(ArrayList<Card> cards) {
        return isRepeatRank(cards,4);
    }

    public static Boolean isFullHouse(ArrayList<Card> cards) {
        if (isThreeOfAKind(cards)) {
 //           ArrayList<Card> remaining = cardsExclude3Kind(cards);
 //           if (isPair(remaining))
                return true;
        }
        return false;
    }


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

    public static Boolean isThreeOfAKind(ArrayList<Card> cards) {
        return isRepeatRank(cards,3);
    }

    public static Boolean isTwoPair(ArrayList<Card> cards) {
        Integer excludeRank = null;

        for(Integer i = 0; i < cards.size(); i++)
        {
            Integer count = 0;
            Integer currentRankNumber = cards.get(i).getRankNumber();
            for (Integer j = i; j < cards.size(); j++) {
                if (cards.get(j).getRankNumber().equals(currentRankNumber))
                    count++;

                if (count >= 2)
                    excludeRank = currentRankNumber;

            }
        }
        return false;
    }

    public static Boolean isPair(ArrayList<Card> cards) {
        return isRepeatRank(cards,2);
    }

    public static Boolean isRepeatRank(ArrayList<Card> cards, Integer numOfRepeat)
    {
        for(Integer i = 0; i < cards.size(); i++)
        {
            Integer count = 0;
            Integer currentRankNumber = cards.get(i).getRankNumber();
            for (Integer j = i; j < cards.size(); j++) {
                if (cards.get(j).getRankNumber().equals(currentRankNumber))
                    count++;

                if (count >= numOfRepeat)
                    return true;
            }
        }
        return false;
    }

}

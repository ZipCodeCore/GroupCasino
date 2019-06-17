import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card cardOne, Card cardTwo) {

        Integer value = cardOne.getRankNumber()-cardTwo.getRankNumber();

        if (value == 0)
            value = cardOne.getSuit().compareTo(cardTwo.getSuit());
        return value;
    }
}

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card cardOne, Card cardTwo) {
        return cardOne.getRank()-cardTwo.getRank();
    }
}

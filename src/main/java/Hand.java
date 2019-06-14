import java.util.ArrayList;

public abstract class Hand {
    private  ArrayList<Card> cards;

    public void sort() {
        CardComparator comparator = new CardComparator();
        cards.sort(comparator);
    }

    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    public Card[] playCard(int ...index) {
        Card[] cardsToPlay = new Card[index.length];
        int count = 0;
        for (int i : index) cardsToPlay[count] = cards.remove(i);
        return cardsToPlay;
    }
}

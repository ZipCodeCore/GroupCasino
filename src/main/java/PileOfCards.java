import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class PileOfCards {

    private Stack<Card> cards;

    public PileOfCards() {
        this.cards = new Stack<Card>();
    }

    public void clear() {
        while (!cards.isEmpty()) cards.pop();
    }

    public void addAll(ArrayList<Card> cardsToAdd) {
        while (cardsToAdd.size() > 0) {
            this.cards.push(cardsToAdd.remove(cardsToAdd.size()-1));
        }
    }
    public void add(Card card) {
        cards.push(card);
    }

    public Card remove() {
        try {
            return cards.pop();
        } catch (EmptyStackException ex) {
            return null;
        }
    }

}

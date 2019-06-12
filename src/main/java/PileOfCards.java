import java.util.Stack;

public class PileOfCards {
    Stack<Card> cards = new Stack<Card>();

    public PileOfCards(Stack<Card> cards) {
        this.cards = cards;
    }

    public void clear() {}
    public void addAll() {}
    public Card remove() {return new Card();}

}

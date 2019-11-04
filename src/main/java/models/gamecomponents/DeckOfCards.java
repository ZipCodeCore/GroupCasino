package models.gamecomponents;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards extends GameComponent {
    private List<Card> deck;

    public DeckOfCards() {
        this.deck = new ArrayList<Card>();
    }

}

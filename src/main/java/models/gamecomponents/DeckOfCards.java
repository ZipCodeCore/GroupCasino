package models.gamecomponents;


import java.util.*;

public class DeckOfCards extends GameComponent {
    private ArrayList<Card> deckOfCards ;

    public DeckOfCards() {
        this.deckOfCards = new ArrayList<>();
        CardSuit[] suits = CardSuit.values();
        CardValue[] values = CardValue.values();
        for(CardSuit suit: suits){
            for(CardValue value: values){
                Card card = new Card(value, suit);
                deckOfCards.add(card);
            }
        }
    }



    public Boolean addToDeck(Card card) {
        this.deckOfCards.add(card);
        return true;
    }

    public ArrayList<Card> shuffle(DeckOfCards deck) {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

}


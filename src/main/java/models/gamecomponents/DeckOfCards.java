package models.gamecomponents;


import java.util.*;

public class DeckOfCards extends GameComponent {
    private Stack<Card> stack;
    private Random random = new Random();

    public DeckOfCards() {
        this.stack = new Stack<Card>();
        CardSuit[] suits = CardSuit.values();
        CardValue[] values = CardValue.values();
        for(CardSuit suit: suits){
            for(CardValue value: values){
                Card card = new Card(value, suit);
                stack.push(card);
            }
        }

    }

}


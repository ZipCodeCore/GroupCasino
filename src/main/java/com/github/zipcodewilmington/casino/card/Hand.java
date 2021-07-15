package com.github.zipcodewilmington.casino.card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private ArrayList<Card> hand;
    private List<Card> warCards;
    private Hand warHand;

    public Hand() {

        hand = new ArrayList<>();
        this.warCards = new ArrayList<Card>();
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setWarHand(Hand warHand) {
        this.warHand = warHand;
    }

    public ArrayList<Card> getHand() {

        return hand;
    }
    public void removeHand(Card i){

        hand.remove(i);
    }
    public void clear(Card i){

        hand.clear();
    }
    public  void add(Card i) {

        hand.add(i);
    }

    public void putCardOnTop(Card warCard) { //add card to hand (deck)
        warCards.add(warCard);
    }

    public void putCardOnBottom(Card warCard) { //add card to bottom of hand (deck)
        warCards.add(0, warCard);
    }

    public void wonCardsToBottom(Card warCard) { //winner puts won cards to bottom of deck
        warCards.add(0, warCard);
    }

    public int handSize() {
        return warCards.size();
    }

    public Card playTopCard() { //play top card of hand (deck)
        return warCards.remove(handSize() - 1 );
    }

    public void addCardsToTop(List<Card> warHand) { //add all cards to hand (deck) array
        this.warCards.addAll(warHand);
    }

    public List<Card> takeCards(int takeCards) {
        List<Card> playedCards = new ArrayList<>();
        for (int i = 0; i < takeCards; i++) {
            playedCards.add(this.warCards.remove(this.handSize() - 1 ));
        }
        return playedCards;
    }
}

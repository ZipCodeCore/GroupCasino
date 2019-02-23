package io.zipcoder.casino.Players;

import io.zipcoder.casino.Cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoFishPlayer extends Player {
    private List<Card> hand;

    public List<Card> getHand() {
        return hand;
    }
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
    public int handSize(){ return hand.size(); }

    public void addToHand(List<Card> cards) {this.hand.addAll(cards);  Collections.sort(hand); }
    public void addToHand(Card card) {this.hand.add(card); Collections.sort(hand); }

    public boolean handContains(String checkFor) {
        boolean hasCard = false;
        for (Card card : hand) {
            if(card.toString().trim().toUpperCase().contains(checkFor.trim().toUpperCase())) {
                hasCard = true;
            }
        }
        return hasCard;
    }

    public List<Card> getCards(String getCard) {
        List<Card> retreivedCards = new ArrayList<>();
        for (Card card : hand) {
            if(card.toString().trim().toUpperCase().contains(getCard.trim().toUpperCase())) {
               retreivedCards.add(card);
            }
        }
        hand.removeAll(retreivedCards);
        return retreivedCards;
    }

    public Card getRandomCard() {
        Collections.shuffle(hand);
        return hand.get(0);
    }

    public boolean hasPairs() {
        if(hand.size() == 1) { return false;}
        for (int i = 0; i < hand.size()-1; i++) {
            if(hand.get(i).equalRank(hand.get(i+1))) {
                return true;
            }
        }
        return false;
    }

    public List<Card> getPairs() {
        List<Card> cardPairs = new ArrayList<>();
        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).equalRank(hand.get(i + 1))) {
                cardPairs.add(hand.get(i));
                cardPairs.add(hand.get(i + 1));
            }
        }
        hand.removeAll(cardPairs);
        return cardPairs;
    }
}

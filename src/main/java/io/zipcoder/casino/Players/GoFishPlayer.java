package io.zipcoder.casino.Players;

import io.zipcoder.casino.Cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoFishPlayer extends Player {
    private List<Card> hand = new ArrayList<>();
    private int bookCount = 0;

    public List<Card> getHand() {
        Collections.sort(hand);
        return hand;
    }
    public void setHand(List<Card> hand) { if(hand != null) {this.hand = hand;} }
    public int getHandSize(){ return hand.size(); }

    public void addToHand(List<Card> cards) {if(hand != null) {this.hand.addAll(cards);} }
    public void addToHand(Card card) {if(hand != null) {this.hand.add(card);} }
    public int getBookCount() {
        return bookCount;
    }
    public void increaseBookCount() {
        bookCount++;
    }

    public boolean hasCard(String checkCard) {
        for (Card card : hand) {
            if(card.toString().contains(checkCard)) {
                return true;
            }
        }
        return false;
    }

    public List<Card> getCards(String getCard) {
        List<Card> retrievedCards = new ArrayList<>();
        for (Card card : hand) {
            if(card.toString().trim().toUpperCase().contains(getCard.trim().toUpperCase())) {
                retrievedCards.add(card);
            }
        }
        hand.removeAll(retrievedCards);
        return retrievedCards;
    }

    public Card getRandomCard() {
        Collections.shuffle(hand);
        return hand.get(0);
    }

    public boolean hasBooks() {
        if(hand.size() < 4) { return false;}
        for (int i = 0; i < hand.size()-3; i++) {
            List<Card> nextFour = getNextFour(i);
            if(Card.equalRank(nextFour)) {
                return true;
            }
        }
        return false;
    }

    public List<Card> getBooks() {
        List<Card> cardBooks = new ArrayList<>();
        for (int i = 0; i < hand.size() - 3; i++) {
            List<Card> nextFour = getNextFour(i);
                if (Card.equalRank(nextFour)) {
                    cardBooks.addAll(nextFour);
                    i+=3;
                    bookCount++;
                }
            }
        hand.removeAll(cardBooks);
        return cardBooks;
    }

    private List<Card> getNextFour(int i) {
        List<Card> nextFour = new ArrayList<>();
        nextFour.add(hand.get(i));
        nextFour.add(hand.get(i+1));
        nextFour.add(hand.get(i+2));
        nextFour.add(hand.get(i+3));
        return nextFour;
    }

}

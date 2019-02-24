package io.zipcoder.casino.Players;

import io.zipcoder.casino.Cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoFishPlayer extends Player {
    private List<Card> hand = new ArrayList<>();
    private int bookCount = 0;

    public List<Card> getHand() {
        return hand;
    }
    public void setHand(List<Card> hand) { if(hand != null) { this.hand = hand;  Collections.sort(hand);} }
    public int getHandSize(){ return hand.size(); }

    public void addToHand(List<Card> cards) {if(hand != null) {this.hand.addAll(cards);  Collections.sort(hand);} }
    public void addToHand(Card card) {if(hand != null) {this.hand.add(card);  Collections.sort(hand);} }
    public int getBookCount() {
        return bookCount;
    }
    public void increaseBookCount() {
        bookCount++;
    }

    public boolean hasCard(String checkCard) {
        String cardRank = parseCardString(checkCard);
        if (cardRank == null){ return false; }
        for (Card card : hand) {
            if(card.toString().contains(cardRank)) {
                return true;
            }
        }
        return false;
    }


    public List<Card> getCards(String getCard) {
        getCard = parseCardString(getCard);
        List<Card> retrievedCards = new ArrayList<>();
        if (getCard == null){ return retrievedCards; }
        for (Card card : hand) {
            if(card.toString().contains(getCard)) {
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

    private String parseCardString(String checkCard) {
        switch (checkCard.toLowerCase()) {
            case "king" :
            case "kings":
            case "k":
            case "ks":
                return "king";
            case "queen" :
            case "queens":
            case "q" :
            case "qs" :
                return "queen";
            case "jack" :
            case "jacks":
            case "j" :
            case "js" :
                return "jack";
            case "ace" :
            case "aces":
            case "a" :
            case "as" :
                return "ace";
            case "10" :
            case "10s" :
            case "ten":
            case "tens":
                return "ten";
            case "9" :
            case "9s" :
            case "nine":
            case "nines":
                return "nine";
            case "8" :
            case "8s" :
            case "eight":
            case "eights":
                return "eight";
            case "7" :
            case "7s" :
            case "seven":
            case "sevens":
                return "seven";
            case "6" :
            case "6s" :
            case "six":
            case "sixs":
                return "six";
            case "5" :
            case "5s" :
            case "five":
            case "fives":
                return "five";
            case "4" :
            case "4s" :
            case "four":
            case "fours":
                return "four";
            case "3" :
            case "3s" :
            case "three":
            case "threes":
                return "three";
            case "2" :
            case "2s" :
            case "two":
            case "twos":
                return "two";
            default:
                 return null;
        }
    }
}

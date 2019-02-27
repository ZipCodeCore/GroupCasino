package io.zipcoder.casino.Players;

import io.zipcoder.casino.CardsAndDice.Card;
import io.zipcoder.casino.CardsAndDice.Rank;

import java.util.*;

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
        Rank cardRank = parseCardString(checkCard);
        if (cardRank == null){ return false; }
        for (Card card : hand) {
            if(card.getRank().equals(cardRank)) {
                return true;
            }
        }
        return false;
    }


    public List<Card> getCards(String getCard) {
        Rank cardRank = parseCardString(getCard);
        List<Card> retrievedCards = new ArrayList<>();
        if (getCard == null){ return retrievedCards; }
        for (Card card : hand) {
            if(card.getRank().equals(cardRank)) {
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

    public static Rank parseCardString(String checkCard) {
        return possibleUserInputs.get(checkCard.toLowerCase());
    }

    private static final HashMap<String, Rank> possibleUserInputs = new HashMap<>();
    static {
        possibleUserInputs.put("king", Rank.KING); possibleUserInputs.put("kings", Rank.KING);
        possibleUserInputs.put("k", Rank.KING); possibleUserInputs.put("ks", Rank.KING);
        possibleUserInputs.put("queen", Rank.QUEEN); possibleUserInputs.put("queens", Rank.QUEEN);
        possibleUserInputs.put("q", Rank.QUEEN); possibleUserInputs.put("qs", Rank.QUEEN);
        possibleUserInputs.put("jack", Rank.JACK); possibleUserInputs.put("jacks", Rank.JACK);
        possibleUserInputs.put("j", Rank.JACK); possibleUserInputs.put("js", Rank.JACK);
        possibleUserInputs.put("ace", Rank.ACE); possibleUserInputs.put("aces", Rank.ACE);
        possibleUserInputs.put("a", Rank.ACE); possibleUserInputs.put("as", Rank.ACE);
        possibleUserInputs.put("ten", Rank.TEN); possibleUserInputs.put("tens", Rank.TEN);
        possibleUserInputs.put("10", Rank.TEN); possibleUserInputs.put("10s", Rank.TEN);
        possibleUserInputs.put("nine", Rank.NINE); possibleUserInputs.put("nines", Rank.NINE);
        possibleUserInputs.put("9", Rank.NINE); possibleUserInputs.put("9s", Rank.NINE);
        possibleUserInputs.put("eight", Rank.EIGHT); possibleUserInputs.put("eights", Rank.EIGHT);
        possibleUserInputs.put("8", Rank.EIGHT); possibleUserInputs.put("8s", Rank.EIGHT);
        possibleUserInputs.put("seven", Rank.SEVEN); possibleUserInputs.put("sevens", Rank.SEVEN);
        possibleUserInputs.put("7", Rank.SEVEN); possibleUserInputs.put("7s", Rank.SEVEN);
        possibleUserInputs.put("six", Rank.SIX); possibleUserInputs.put("sixes", Rank.SIX);
        possibleUserInputs.put("6", Rank.SIX); possibleUserInputs.put("6s", Rank.SIX);
        possibleUserInputs.put("five", Rank.FIVE); possibleUserInputs.put("fives", Rank.FIVE);
        possibleUserInputs.put("5", Rank.FIVE); possibleUserInputs.put("5s", Rank.FIVE);
        possibleUserInputs.put("four", Rank.FOUR); possibleUserInputs.put("fours", Rank.FOUR);
        possibleUserInputs.put("4", Rank.FOUR); possibleUserInputs.put("4s", Rank.FOUR);
        possibleUserInputs.put("three", Rank.THREE); possibleUserInputs.put("threes", Rank.THREE);
        possibleUserInputs.put("3", Rank.THREE); possibleUserInputs.put("3s", Rank.THREE);
        possibleUserInputs.put("two", Rank.TWO); possibleUserInputs.put("twos", Rank.TWO);
        possibleUserInputs.put("2", Rank.TWO); possibleUserInputs.put("2s", Rank.TWO);
    }

}

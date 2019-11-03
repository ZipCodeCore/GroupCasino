package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BlackjackHand {

    private CardSet cards;
    private double bet;
    private int value;
    private BlackjackPlayer player;

    public BlackjackHand(double bet, BlackjackPlayer player, Card card1, Card card2) {
        this.bet = bet;
        this.player = player;
        this.cards = new CardSet(0);
        this.cards.addCard(card1);
        this.cards.addCard(card2);
    }

    public CardSet getCards() {
        return cards;
    }

    public double getBet() {
        return bet;
    }

    public int getValue() {
        return value;
    }

    public BlackjackPlayer getPlayer() {
        return player;
    }

    public void setCards(CardSet cards) {
        this.cards = cards;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPlayer(BlackjackPlayer player) {
        this.player = player;
    }

    public void clear() {
        this.cards.clear();
    }

    public void addCard(Card card) {
        this.cards.addCard(card);
    }

    public int size() {
        return this.cards.size();
    }

    public int playChoice(){
        return 0;
    }

    public int determineHandValue() {
        ArrayList<Integer> values = mapCardValues(this.cards);
        int sumValue = arraySum(values);
        if (sumValue <= 21) {
            return sumValue;
        } else {
            if (values.contains(11)) {
                int numAces = values.size() - values.indexOf(11);
                for (int i = 1; i <= numAces; i++) { // loop through, turning 11's into 1's until it's legal
                    sumValue -= 10;
                    if (sumValue <= 21) {
                        return sumValue;
                    }
                }
            }
            return 0; //bust
        }
    }

    public ArrayList<Integer> mapCardValues(CardSet cards) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (Card card: cards.getCards()) {
            values.add(BlackjackGame.cardMap.get(card.getRank()));
        }
        Collections.sort(values,Collections.reverseOrder());
        return values;
    }

    public int arraySum(ArrayList<Integer> array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    //
    public BlackjackHand splitHand() {
        return null;
    }


}

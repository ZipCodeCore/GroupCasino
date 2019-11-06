package io.zipcoder.casino.Blackjack;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.Utilities.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BlackjackHand {

    private CardSet cards;
    private double bet;
    private int value;
    private BlackjackPlayer player;
    private Console console = new Console(System.in, System.out);
    private GameServices gameServices = new GameServices();
    private Logger logger = Logger.getLogger(BlackjackHand.class.getName());

    public BlackjackHand(double bet, BlackjackPlayer player, Card card1, Card card2) {
        this.bet = bet;
        this.player = player;
        this.cards = new CardSet(0);
//        if (card2 != null) {
//            this.cards.addCard(new Card("5", "H"));
//            this.cards.addCard(new Card("5", "D"));
//        } else {
        this.cards.addCard(card1);
        if (card2 != null) {
            this.cards.addCard(card2);
        }
//        }
    }

    public CardSet getCards() {
        return cards;
    }

    public double getBet() {
        return bet;
    }

    public BlackjackPlayer getPlayer() {
        return player;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }

    public void setCards(CardSet cards) { //just for testing
        this.cards = cards;
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

    public int playChoice(CardSet shoe){
        if (this.cards.size() == 2 && this.cards.getCards().get(0).equals(this.cards.getCards().get(1))) {
            splitHand();
            return -1;
        } else { // normal case
            console.printWithDelays("1. Hit\n2. Stay\n");

            switch (console.menuChoice(2)) {
                case 1:
                    int val = hit(shoe.removeFirstCard());
                    if (val != 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                case 2:
                    return this.getValue();
            }
            return -1;
        }

    }

    public int hit(Card card) {
        this.cards.addCard(card);
        this.value = getValue();
        return this.value;
    }

    public void splitHand() {
        Card card = this.cards.removeFirstCard();
        this.player.addHand(new BlackjackHand(this.bet, this.player, card, null));
        gameServices.wager(this.bet, this.player.getPlayer());
    }

    public int getValue() {
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
//        logger.log(Level.INFO, "==================");
//        logger.log(Level.INFO, values.toString());
        Collections.sort(values);
//        logger.log(Level.INFO, values.toString());
        return values;
    }

    public int arraySum(ArrayList<Integer> array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

}

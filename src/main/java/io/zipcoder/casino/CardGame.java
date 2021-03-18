package io.zipcoder.casino;

import java.util.*;

public abstract class CardGame implements GamblingGame {
    ArrayList<String> playersHand;
    ArrayList<String> dealersHand;
    ArrayList<String> deck;
    TreeMap<String, Integer> deckMap;
    String[] ranks;
    String[] suits;

    public CardGame() {

        this.deck = new ArrayList<String>(52);
        // Set zeroth element to null to indicate an unused element (only valid ranks from 1-13)
        this.ranks = new String[]{null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        this.suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
        this.playersHand = new ArrayList<String>();
        this.dealersHand = new ArrayList<String>();
        this.deckMap = new TreeMap<String, Integer>();
    }

    public ArrayList<String> getDeck() {
        return this.deck;
    }

    // needed for testing
    public void setPlayersHand(ArrayList<String> playersHand) {
        this.playersHand = playersHand;
    }

    public ArrayList<String> getPlayersHand() {
        return this.playersHand;
    }

    public ArrayList<String> getDealersHand() {
       return this.dealersHand;
    }

    public void createNewDeck() {
        for (int suit = 0; suit <=3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.deck.add(this.ranks[rank] + " of " + this.suits[suit]);
            }
        }
    }

    public void shuffleCards() {
        ArrayList<String> temp = new ArrayList<String>(52);
        while(!this.deck.isEmpty()) {
            int randCard = (int) (Math.random() * deck.size());
            temp.add(this.deck.get(randCard));
            this.deck.remove(randCard);
        }
        this.deck = temp;
    }

    public void dealCards(int numberOfCards) {
        int i = 0;
        while (i < numberOfCards * 2) {
            if (i < numberOfCards) {
                this.playersHand.add(this.deck.get(i));
            } else if (i >= numberOfCards) {
                this.dealersHand.add(this.deck.get(i));
            }
            this.deck.remove(i);
            i++;
        }
    }

    public String getRankOnCard(String cardRankAndSuit) {
        return cardRankAndSuit.substring(0, cardRankAndSuit.indexOf(" "));
    }

    public int getValueOfCard(String rankOnCard) {
        int valueOfCard = 0;
        if (rankOnCard.equals("Ace") || rankOnCard.equals("Jack") || rankOnCard.equals("King") || rankOnCard.equals("Queen")) {
            valueOfCard = 10;
        } else {
            valueOfCard = Integer.parseInt(rankOnCard);
        }

        return valueOfCard;
    }

    public String displayPlayersHand(ArrayList<String> playersHand) {
        String playersHandOutput = "";
        Iterator itr = playersHand.iterator();
        while(itr.hasNext()) {
            playersHandOutput += itr.next() + "\n";
        }
        return playersHandOutput;
    }
    
}

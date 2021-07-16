package com.github.zipcodewilmington.casino.card;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(ArrayList<Card> deck) {
        this.cards = deck;
    }

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void buildDeck(){
        for(SuitValue cardSuit: SuitValue.values()){
            for(CardValue cardValue : CardValue.values()){
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void shuffle(){
        ArrayList<Card> tempD = new ArrayList<>();
        Random random = new Random();
        int randomIndex = 0;
        int originSize = this.cards.size();
        for(int i = 0; i < originSize; i++){
            randomIndex = random.nextInt((this.cards.size() - 1) + 1); //rand.nextInt((max-min) + 1) + min;
            tempD.add(this.cards.get(randomIndex));
            this.cards.remove(randomIndex);
        }
        this.cards=tempD;
    }

    public void draw(Deck deck) {
        this.cards.add(deck.cards.get(0));
        deck.cards.remove(0);
    }

    public Card drawCard(){
        return this.cards.get(0);
    }

    public Deck splitFirst() {
        ArrayList<Card> first = new ArrayList<Card>(this.cards.subList(0, (this.cards.size()) / 2));
        Deck firstHalf = new Deck(first);

        return firstHalf;
    }

    public Deck splitSecond() {
        ArrayList<Card> second = new ArrayList<Card>(this.cards.subList((this.cards.size()) / 2, this.cards.size()));
        Deck secondHalf = new Deck(second);

        return secondHalf;

    }

    public Integer getSize(){
        return this.cards.size();
    }

    public void cardRemove(Card card) {
        this.cards.remove(card);
    }


    public int cardValue() {
        int totalValue = 0;
        int aces = 0;

        for (Card c : this.cards) {
            switch (c.getCardValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                    totalValue += 10;
                    break;
                case JACK:
                    totalValue += 10;
                    break;
                case QUEEN:
                    totalValue += 10;
                    break;
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    aces += 1;
                    break;

            }
        }
        for (int i = 0; i < aces; i++) {
            if (totalValue > 10) {
                totalValue += 1;
            }else{
                totalValue += 11;
            }
        }
        return totalValue;
    }
    public Card getCard(int i){
        return this.cards.get(i);
    }
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
    public int sizeOfDeck(){
        return this.cards.size();
    }
}

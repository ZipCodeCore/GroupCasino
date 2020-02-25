package io.zipcoder.casino.GameClasses.CardGames;

import io.zipcoder.casino.Player.Hand;

import java.util.Stack;

public class Deck {
    Stack<Card> currentDeck = new Stack<Card>();

    public Deck(){
        for (int i = 0;i<13;i++) {
            EnumRank rank = EnumRank.values()[i];
            for (int j = 0; j < 4; j++) {
                Card newCard = new Card(rank, EnumSuit.values()[j]);
                this.currentDeck.push(newCard);
            }
        }
    }
    public Deck Shuffle(){return null;}

    public Card Draw(){return null;}

    public Hand Show(){return null;}




}

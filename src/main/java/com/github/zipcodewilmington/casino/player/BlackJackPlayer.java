package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.card.Deck;
import com.github.zipcodewilmington.casino.card.Hand;
import com.github.zipcodewilmington.casino.games.Blackjack;

public class BlackJackPlayer {
    private Hand hand = new Hand();
    private Deck deck = new Deck();
    private Blackjack blackjack = new Blackjack();
    private Player player;

    public BlackJackPlayer(Player player) {
        this.player = player;
    }

    public Hand getHand() {
        return hand.getHand();
    }

    public Player getPlayer() {
        return this.player;
    }

    public String hit() {
        String topCard = deck.pop();
        String newCard = "";
        for (int i = 0; i < hand.size(); i++) {
             if(newCard != hand(i)) {
                 newCard = topCard;
             }
        }
        return newCard;
    }

    public String stay() {
        return blackJack.cardSum;
    }


}

package com.github.zipcodewilmington.casino.games.cards;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.objects.Card;

import java.util.ArrayList;

public class BlackjackPlayer extends Player{
    ArrayList<Card> hand;

    public BlackjackPlayer(ArrayList<Card> hand, String name, String password, float balance, float currentBet) {
        super(name, password, balance, currentBet);
        this.hand = hand;
    }
}

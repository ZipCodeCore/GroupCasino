package com.github.zipcodewilmington.casino.games.cards;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.objects.Card;

import java.util.ArrayList;

public class CardPlayer {
    ArrayList<Card> hand;

    public CardPlayer(ArrayList<Card> hand) {
        this.hand = hand;
    }
}

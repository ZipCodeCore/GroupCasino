package com.github.zipcodewilmington.casino.player;

import com.github.zipcodewilmington.casino.card.Deck;
import com.github.zipcodewilmington.casino.card.Hand;
import com.github.zipcodewilmington.casino.games.Blackjack;

public class BlackJackDealer extends Player{
    private Hand hand = new Hand();
    private Deck deck = new Deck();
    private Blackjack blackjack = new Blackjack();

}

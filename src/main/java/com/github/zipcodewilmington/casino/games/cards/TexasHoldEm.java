package com.github.zipcodewilmington.casino.games.cards;

import com.github.zipcodewilmington.casino.objects.Deck;


// Texas-Hold-Em begins with a beginning $ ante. Each player then receives 2 cards from the dealer.
// Beginning with the player to the left of the dealer.
// The player may: (FOLD, CALL, RAISE, CHECK)
// The game continues to each player until all players have fully placed bets
// The dealer then reveals the Flop - (first 3 community cards revealed)
// Play loops through players again
// Dealer reveals the Turn - (fourth community card revealed)
// Play loops through

public class TexasHoldEm {



    Deck deck;

    public TexasHoldEm(Deck deck) {
        this.deck = deck;
    }


}

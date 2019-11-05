package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class GoFish implements Game {
    Deck deck = new Deck();
    Console console = new Console(System.in, System.out);
    Card[] playerHand = new Card[6];
    Card[] dealerHand = new Card[6];
    private Player currentPlayer;
    private boolean currentGame = true;
    boolean running = true;





    @Override
    public void approachTable(Player currentPLayer) {

    }

    @Override
    public void runGame(Player currentPlayer) {

    }

    @Override
    public void exitGame(Player currentPlayer) {

    }
}

package io.zipcoder.casino.Games.GoFish;

import io.zipcoder.casino.GamePieces.Card;
import io.zipcoder.casino.GamePieces.Deck;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GoFish implements Game {
    Deck deck = new Deck();
    Console console = new Console(System.in, System.out);
    ArrayList<Card> playerHand = new ArrayList<>();
    ArrayList<Card> dealerHand = new ArrayList<>();
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

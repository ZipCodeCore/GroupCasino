package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;

import java.util.ArrayList;

public class GoFish {

    Player user = new Player();
    Integer pointAccumulated;
    Integer hasCardQuestion;
    Deck goFishDeck = new Deck();

    public void startGame(){}

    public boolean askForCard(Player thisPlayer, int cardNumber){}

    public void tradeCards(ArrayList fromPlayer, ArrayList toPlayer){}

    public void dropCards (Player playerToDrop){}

    public void promptLeaveGame(){}

    public void displayResults (){}
}

package io.zipcoder.casino.GameClasses;

import io.zipcoder.casino.Player.Player;

public interface Game {

    public void startGame();

    public Boolean quitGame();

    public Boolean win();

    public Boolean playAgain();

    public Player playerBuilder();
}

package io.zipcoder.casino.Games;

import io.zipcoder.casino.Player;

public interface Game {

    void approachTable(Player currentPLayer);
    void runGame(Player currentPlayer);
    void exitGame();

}

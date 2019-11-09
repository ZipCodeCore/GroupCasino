package io.zipcoder.casino.Games;

import io.zipcoder.casino.PlayerCreation.Player;

public interface Game {

    void approachTable(Player currentPLayer);
    void runGame(Player currentPlayer);
    void exitGame(Player currentPlayer);


}

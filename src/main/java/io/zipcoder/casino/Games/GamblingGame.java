package io.zipcoder.casino.Games;

import io.zipcoder.casino.Player;

public interface GamblingGame {

    void placeBet(Player currentPlayer);
    void returnWinnings(Player currentPlayer);

}

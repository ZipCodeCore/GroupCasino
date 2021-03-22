package io.zipcoder.casino;

import java.util.Random;

public interface Game {
    Random random =new Random();

    Integer numberOfPlayers = 0;
    Boolean GameState = false;

    public String checkForWinner();

}

package io.zipcoder.casino.games;


import java.security.PublicKey;

abstract class Games {
    Integer odds;


    abstract void nextTurn();

    abstract void endGame();

    abstract boolean getResults();

    public void display(String output) {
        System.out.println(output);
    }


}

package io.zipcoder.casino.games;


import java.security.PublicKey;

abstract class Games {

    Double odds;

    abstract void nextTurn();

    abstract void endGame();

    abstract boolean getResults();

    void display(String output) {
        System.out.println(output);
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }



}

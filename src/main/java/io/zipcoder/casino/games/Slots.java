package io.zipcoder.casino.games;

import io.zipcoder.casino.player.SlotsPlayer;

public class Slots extends Games implements GamblerGameInterface {
    Integer numOfLines;
    SlotsPlayer slotsPlayer = new SlotsPlayer();

    public Slots(){}

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {

    }
}

package io.zipcoder.casino.games;

import io.zipcoder.casino.player.RoulettePlayer;

public class Roulette extends Games implements GamblerGameInterface {
    String betType; //   red/back - odd / even / number
    RoulettePlayer roulettePlayer = new RoulettePlayer();


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

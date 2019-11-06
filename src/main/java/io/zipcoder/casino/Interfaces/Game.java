package io.zipcoder.casino.Interfaces;

public interface Game {

    void startPlay() throws InterruptedException;

    void endChoice();

    void roundOfPlay();

}

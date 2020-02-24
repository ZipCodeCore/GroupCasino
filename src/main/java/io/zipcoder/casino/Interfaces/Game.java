package io.zipcoder.casino.Interfaces;

public interface Game {

    void startPlay() throws InterruptedException;

    void endChoice() throws InterruptedException;

    void roundOfPlay() throws InterruptedException;

}

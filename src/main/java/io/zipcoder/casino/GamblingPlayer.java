package io.zipcoder.casino;

public interface GamblingPlayer {

    void deposit(double amount);

    void cashOut();

    void buyMarker(double amount);

    void addChips(double amount);

}

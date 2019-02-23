package io.zipcoder.casino.Players;

public class MacaoPlayer extends DicePlayer {

    public int roll;
    public int cumulativeRoll;

    public MacaoPlayer(Profile profile) {
        super(profile);
        this.roll = 0;
        this.cumulativeRoll = 0;
    }

}

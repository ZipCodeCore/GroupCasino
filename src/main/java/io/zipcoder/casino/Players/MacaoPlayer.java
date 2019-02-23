package io.zipcoder.casino.Players;

import io.zipcoder.casino.Casino.Casino;

public class MacaoPlayer extends Player {

    public int roll;
    public int cumulativeRoll;

    public MacaoPlayer() {
        this.roll = 0;
        this.cumulativeRoll = 0;
    }

    public MacaoPlayer(Profile profile) {
        super(profile);
        this.roll = 0;
        this.cumulativeRoll = 0;
    }

}

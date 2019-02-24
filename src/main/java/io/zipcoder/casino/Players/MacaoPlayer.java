package io.zipcoder.casino.Players;

public class MacaoPlayer extends Player {

    private int roll;
    private int cumulativeRoll;

    public MacaoPlayer() {
        this.roll = 0;
        this.cumulativeRoll = 0;
    }

    public MacaoPlayer(Profile profile) {
        super(profile);
        this.roll = 0;
        this.cumulativeRoll = 0;
    }

    public Profile getProfile() {
        return super.getProfile();
    }

    public int getRoll() {
        return roll;
    }

    public int getCumulativeRoll() {
        return cumulativeRoll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
        this.cumulativeRoll += roll;
    }

    public void setCumulativeRoll(int roll) {
        this.cumulativeRoll = roll;
    }
}



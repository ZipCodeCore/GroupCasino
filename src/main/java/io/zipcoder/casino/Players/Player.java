package io.zipcoder.casino.Players;


public abstract class Player {
    private Profile profile;
    public Player(Profile profile) {

        this.profile = profile;
    }
    public Player() {
        profile = new Profile();
    }
}

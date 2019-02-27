package io.zipcoder.casino.casino;


public abstract class Player {
    private Profile profile;
    public Player(Profile profile) {

        this.profile = profile;
    }
    public Player() {
        profile = new Profile();
    }

    public Profile getProfile() {
        return this.profile;
    }
}

package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;


public class Casino {
    public static GuestAccountDataBase guestAccountDatabase;
    public static Console console;
    private Guest currentGuest;

    public void startCasinoExperience() {
        CasinoGames casinoGames = new CasinoGames();

        casinoGames.runSelectedGames();
    }

}
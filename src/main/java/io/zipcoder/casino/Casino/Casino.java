package io.zipcoder.casino.Casino;

import io.zipcoder.casino.Players.Profile;

public class Casino {
    private static Profile profile;
    private static Greeter greeter = new Greeter();
    private static boolean userIsLeaving;
    public static void main(String[] args)
    {
        entertainUser();
    }

    private static void entertainUser() {
        greetUser();
        while (!userIsLeaving) {
            String nextGame = offerUserGames();
            playGameWithUser(nextGame);
        }
        seeUserOut();
    }

    private static void playGameWithUser(String nextGame) {
    }

    private static String offerUserGames() {
        String nextGame;
        if(profile.isGambler()) {
            nextGame = greeter.getNextGame();
        } else {
            nextGame = greeter.getNextCleanGame();
        }
        return nextGame;
    }

    private static void greetUser() {
        String name = greeter.getUserName();
        Boolean gambing = greeter.getIfGambling(name);
        profile = new Profile(name, gambing);
    }

    private static void seeUserOut() {

    }

    public static Profile getProfile() {
        return profile;
    }
}

package io.zipcoder.casino.Casino;


import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.Players.Profile;



public class Casino {
    private static Profile profile = new Profile();
    private static Greeter greeter = new Greeter();
    private static boolean userIsLeaving = false;

    public static void main(String[] args)
    {
        entertainUser();
    }

    public static void entertainUser() {
        greetUser();
        while (!userIsLeaving) {
            Game nextGame = offerUserGames();
            playGameWithUser(nextGame);
            offerUserLeave();
        }
        seeUserOut();
    }

    public static void greetUser() {
        String name = greeter.getUserName();
        Boolean gambing = greeter.getIfGambling(name);
        profile = new Profile(name, gambing);
    }

    public static Game offerUserGames() {
        Game nextGame;
        if(profile.isGambler()) {
            nextGame = greeter.getNextGame();
        } else {
            nextGame = greeter.getNextCleanGame();
        }
        return nextGame;
    }

    public static void playGameWithUser(Game nextGame) {
        nextGame.play();
    }


    public static void offerUserLeave() {
        if(profile.getBalance() > 0) {
            userIsLeaving = greeter.getIfLeaving();
        } else {
            greeter.balanceTooLow();
            userIsLeaving = true;
        }
    }

    public static void seeUserOut() {
        greeter.goodBye();
    }

    public static Profile getProfile() {
        return profile;
    }
    public static void setProfile() {
         profile = new Profile();
    }

    public static void setGreeter(Greeter newGreeter) {
        greeter = newGreeter;
    }

    public static boolean isUserIsLeaving() {
        return userIsLeaving;
    }
}

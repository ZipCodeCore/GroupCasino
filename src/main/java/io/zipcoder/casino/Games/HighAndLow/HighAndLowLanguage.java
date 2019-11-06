package io.zipcoder.casino.Games.HighAndLow;

import java.util.HashMap;

public class HighAndLowLanguage {

    HashMap<String, String> highAndLowLanguage = new HashMap<>();

    public HighAndLowLanguage(){
        this.highAndLowLanguage.put("approachTable", "The High and Low table... reputed as the lowest of casino games.\n" +
                "Diminishing returns for the despairing and unfortunate who have fallen too hard on their bad luck.\n" +
                "Desperation permeates from the eyes of those gathered around the moldy table,\n" +
                "gravely placing their hopes to win back ANYTHING from their losses in this last-ditch game of chance.\n" +
                "Have they really sunk that low to be playing this game?\n" +
                "\"Have I?\" you think to yourself as you approach the table.\n\nWhat would you like to do?\n\n");
        this.highAndLowLanguage.put("rules","\n\nA simple game for meager winnings. At High and Low,\n" +
                "you'll only be able to bet $10. Simply roll two dice, and our pit boss will\n" +
                "present to you the sum of the rolls and the chance to bet High or Low.\n" +
                "If you believe the sum of the second roll will be higher, bet high.\n" +
                "Likewise, if you believe the sum of the second roll will be lower, bet low.\n" +
                "Pray for an early 2,3,11, or 12 because they are the easiest to predict against.\n" +
                "Hence why you're only allowed to be $10.\n\n" +
                "What? We're not in the business of giving away money.\n\n");
        this.highAndLowLanguage.put("approachTableMenu", "(1) - Play the game\n(2) - Read the rules\n(3) - Return to the game menu");
        this.highAndLowLanguage.put("placeBet","At High and Low, you can only bet $10.\nWould you like to bet $10?\n(1) - Yes, bet $10.\n(2) - No, let it ride.");
        this.highAndLowLanguage.put("playAgain", "\"Would you like to play again?\n(1) - Yes\n(2) - No");
        this.highAndLowLanguage.put("didNotRoll", "Sorry, you did not bet the first roll.\n" +
                "But we'll be nice and still let you guess.");
        this.highAndLowLanguage.put("highOrLow", "Do you want to bet High or Low?\n(1) - High\n(2) - Low");
        this.highAndLowLanguage.put("lose", "Sorry, you've lost. Try again soon!");

    }

    public String getHighAndLowLanguage(String game){ return highAndLowLanguage.get(game);}

}


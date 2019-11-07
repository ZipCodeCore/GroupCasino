package io.zipcoder.casino.Games.HighAndLow;

import java.util.HashMap;

public class HighAndLowLanguage {

    HashMap<Language, String> highAndLowHashMap = new HashMap<>();

    public enum Language{
        APPROACHTABLE, RULES,APPROACHTABLEMENU,PLAYAGAIN,HIGHORLOW,LOSE,DIDNOTBET2,BUYIN,PLACESECONDBET,NOTENOUGHMONEY;
    }

    public String getHighAndLowLanguage(Language key) {
        return highAndLowHashMap.get(key);
    }

    public HighAndLowLanguage(){
        this.highAndLowHashMap.put(Language.APPROACHTABLE, "The High and Low table... reputed as the lowest of casino games.\n" +
                "Diminishing returns for the despairing and unfortunate who have fallen too hard on their bad luck.\n" +
                "Desperation permeates from the eyes of those gathered around the moldy table,\n" +
                "gravely placing their hopes to win back ANYTHING from their losses in this last-ditch game of chance.\n" +
                "Have they really sunk that low to be playing this game?\n" +
                "\"Have I?\" you think to yourself as you approach the table.\n\nWhat would you like to do?\n\n");
        this.highAndLowHashMap.put(Language.RULES,"\n\nA simple game for meager winnings. At High and Low,\n" +
                "you'll only be able to but in at $10. Simply roll two dice, and our pit boss will\n" +
                "present to you the sum of the rolls and the chance to bet $10 more on High or Low.\n" +
                "If you believe the sum of the second roll will be higher, bet high.\n" +
                "Likewise, if you believe the sum of the second roll will be lower, bet low.\n");
        this.highAndLowHashMap.put(Language.NOTENOUGHMONEY, "The pit boss glares are you, seemingly knowing you don't have enough money\n" +
                "to pay even the buy-in cost.\nHe shakes his head, branding his red stick in hand with a menacing grasp.\n" +
                "Perhaps it's best if you accept your losses and drag your sorry self home.\nTomorrow is a new day... maybe.\n\n");


        this.highAndLowHashMap.put(Language.APPROACHTABLEMENU, "(1) - Play the game\n(2) - Read the rules\n(3) - Return to the game menu");
        this.highAndLowHashMap.put(Language.BUYIN,"Sitting at the table, you commit yourself to a $10 bet. Too late to back out now!");
        this.highAndLowHashMap.put(Language.PLAYAGAIN, "Would you like to play again?\n(1) - Yes\n(2) - No");
        this.highAndLowHashMap.put(Language.HIGHORLOW, "Do you want to bet High or Low?\n(1) - High\n(2) - Low");
        this.highAndLowHashMap.put(Language.LOSE, "Sorry, you've lost. Try again soon!");
        this.highAndLowHashMap.put(Language.DIDNOTBET2, "No bets? Okay, all fun and games here.\nWe'll still let you pick.");
        this.highAndLowHashMap.put(Language.PLACESECONDBET, "Now, you will be asked to bet on High or Low.\nWould you like to bet $10 again?\n(1) - Yes, bet $10\n(2) - Nope, I'm out.");

    }



}


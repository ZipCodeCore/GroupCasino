package io.zipcoder.casino;

public class BeetleDisplay extends Display{

    public void rules() {
        currentDisplaySP("Draw the beetle before your opponent and win big!\nThe rules are simple:\nEach side of the die correspond to a part of the beetle." +
                "\n If you roll a number, you get to draw that part\nIf you roll the same number again, you do not get to add to your beetle." +
                "\nBetween each roll you will add to your wager.\n The first person to draw a beetle keeps the purse.\n" +
                "\nIf both players complete their beetle on the same set of rolls the wagers are returned." +
                " What to draw for each roll:" +
                "\n1 - head\n2 - body\n3 - left front leg\n4 - right front leg\n5 - left back leg\n6 - right back leg");
    }

    public void drewLeg() {
        currentDisplaySP("You added a leg to your beetle!");
    }

    public void drewBody() {
        currentDisplaySP("You drew your beetle's body!");
    }

    public void drewHead() {
        currentDisplaySP("You drew your beetle's head!");
    }

    public void yourBugIsComplete() {
        currentDisplaySP("Your beetle is complete!");
    }

    public void opponentsBugisComplete() {
        currentDisplaySP("Your opponents beetle is complete.");
    }

    public void bothBeetlesComplete(){currentDisplaySP("You both drew beetles. The game is a tie.");}

    public void repeatedRollResult() {
        currentDisplaySP("You already rolled that number.");
    }
}

package io.zipcoder.casino;

public class BeetleDisplay extends Display {

    String[][] beetle = new String[][]{{"\\","0","/"},
            {"⎛","|","⎞"},
            {"⎝","|","⎠"},
            {"/","⏝","\\"}
    };

    public BeetleDisplay() {
    }

    public void rules() {
        setPrintCurrentDisplay("Draw the beetle before your opponent and win big!\nThe rules are simple:\nEach side of the die corresponds to a part of the beetle." +
                "\nIf you roll a number, you get to draw that part.\nIf you roll the same number again, you do not get to add to your beetle." +
                "\nBetween each roll you will add to your wager.\nThe first person to draw a beetle keeps the purse." +
                "\nIf both players complete their beetle on the same set of rolls the wagers are returned." +
                "\n\nWhat to draw for each roll:" +
                "\n1 - head\n2 - body\n3 - left front leg\n4 - right front leg\n5 - left back leg\n6 - right back leg");
    }

    public void drewLeg() {
        setPrintCurrentDisplay("A leg was added to the beetle!");
    }

    public void drewBody() {
        setPrintCurrentDisplay("The beetle's body was drawn!");
    }

    public void drewHead() {
        setPrintCurrentDisplay("This beetle has a head now!");
    }

    public void userBugIsComplete() {
        setPrintCurrentDisplay("Your beetle is complete!\nYOU WIN!!!!");
    }

    public void opponentsBugisComplete() {
        setPrintCurrentDisplay("Your opponents beetle is complete.\nYou lose.");
    }

    public void bothBeetlesComplete() {
        setPrintCurrentDisplay("You both drew beetles. The game is a tie.");
    }

    public void usersRollResults(Integer usersRoll) {
        setPrintCurrentDisplay("You rolled a " + usersRoll);
    }

    public void opponentsRollResults(Integer opponentsRoll) {
        setPrintCurrentDisplay("Your opponent rolled a " + opponentsRoll);
    }

    public void repeatedRollResult() {
        setPrintCurrentDisplay("You already rolled that number.");
    }

    //Beetle Body Parts
    public void getBeetleComplete() {
        for (int i = 0; i < beetle.length; i++) {
            for (int j = 0; j < beetle[i].length; j++) {
                System.out.print(beetle[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void border() {
        setPrintCurrentDisplay("\n======================\n");
    }

    public void openingBetMessage() {
        setPrintCurrentDisplay("This game has a table minimum of $1");
    }

    public void opponentHasPlacedABet(Double betAmount) {
        setPrintCurrentDisplay("Your opponent has placed a bet of " + betAmount);
    }

    public void currentPurse(Double purse) {
        setPrintCurrentDisplay("The purse is currently at " + purse);
    }


}
package io.zipcoder.casino;

public class BeetleDisplay extends Display {

    String[][] beetle = new String[][]{{"\\","0","/"},
            {"⎛","|","⎞"},
            {"⎝","|","⎠"},
            {"/","⏝","\\"}
    };

    public BeetleDisplay() {
    }

    public String welcome() {
        String message ="WELCOME TO BEETLE!\n(1 dollar per player table minimum)\n";
        setPrintCurrentDisplay(message);
        return message;
    }
    public void rules() {
        setPrintCurrentDisplay("\nDraw the beetle before your opponent and win big!\nThe rules are simple:\nEach side of the die corresponds to a part of the beetle." +
                "\nIf you roll a number, you get to draw that part.\nIf you roll the same number again, you do not get to add to your beetle." +
                "\nBetween each roll you will add to your wager.\nThe first person to draw a beetle keeps the purse." +
                "\nIf both players complete their beetle on the same set of rolls the wagers are returned." +
                "\n\nWhat to draw for each roll:" +
                "\n1 - head\n2 - body\n3 - left front leg\n4 - right front leg\n5 - left back leg\n6 - right back leg\n\n");
    }

    public String drewLeg() {
        String message = "A leg was added to the beetle!";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String drewBody() {
        String message ="The beetle's body was drawn!";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String drewHead() {
        String message ="This beetle has a head now!";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String userBugIsComplete() {
        String message ="Your beetle is complete!\nYOU WIN!!!!";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String opponentsBugisComplete() {
        String message ="Your opponents beetle is complete.\nYou lose.";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String bothBeetlesComplete() {
        String message ="You both drew beetles. The game is a tie.";
        setPrintCurrentDisplay(message);
        return message;
    }

    public void usersRollResults(Integer usersRoll) {
        setPrintCurrentDisplay("You rolled a " + usersRoll);
    }

    public void opponentsRollResults(Integer opponentsRoll) {
        setPrintCurrentDisplay("Your opponent rolled a " + opponentsRoll);
    }

    public String repeatedRollResult() {
        String message ="You already rolled that number.";
        setPrintCurrentDisplay(message);
        return message;
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
    public String border() {
        String message ="======================";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String borderWithSpace() {
        String message ="\n======================\n";
        setPrintCurrentDisplay(message);
        return message;
    }


    public String openingBetMessage() {
        String message ="This game has a table minimum of $1";
        setPrintCurrentDisplay(message);
        return message;
    }

    public void opponentHasPlacedABet(Double betAmount) {
        setPrintCurrentDisplay("Your opponent has placed a bet of $" + betAmount);
    }

    public void currentPurse(Double purse) {
        setPrintCurrentDisplay("The purse is currently at $" + purse);
    }

    public String yourBeetle() {
        String message ="YOUR BEETLE";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String opponentsBeetle() {
        String message ="OPPONENTS BEETLE";
        setPrintCurrentDisplay(message);
        return message;
    }

}
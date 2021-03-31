package io.zipcoder.casino;

public class BeetleDisplay extends Display {

    String[][] beetle = new String[][]{{"\\","0","/"},
            {"⎛","|","⎞"},
            {"⎝","|","⎠"},
            {"/","⏝","\\"}
    };

    public BeetleDisplay() {
    }

    public String welcome(String playerName) {
        String message ="WELCOME TO BEETLE, "+ playerName +"!\n(1 dollar per player table minimum)\n";
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

    public void opponentHasPlacedABet(Double betAmount) {
        setPrintCurrentDisplay("Opponent bet: $" + betAmount);
    }
    public void userHasPlacedABet(Double betAmount) {
        setPrintCurrentDisplay("Your bet: $" + betAmount);
    }

    public void currentPurse(Double purse) {
        setPrintCurrentDisplay("The purse is currently at $" + purse);
    }

    public String yourBeetleTitleLine() {
        String message ="YOUR BEETLE";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String opponentsBeetleTitleLine() {
        String message ="OPPONENTS BEETLE";
        setPrintCurrentDisplay(message);
        return message;
    }

    public String[][] drawPlayerBeetle(String[][] playersBeetle){
        for (int i = 0; i < playersBeetle.length; i++) {
            for (int j = 0; j < playersBeetle[i].length; j++) {
                System.out.print(playersBeetle[i][j] + " ");
            }
            System.out.println();
        }
        return playersBeetle;
    }

    public void displayWelcomeSequence(Player player, String[][] beetle) {
        welcome(player.getName());
        drawPlayerBeetle(beetle);
        rules();
    }

    public void gameBoard(Integer userRollValue, String[][] usersBeetle, Integer opponentsRollValue,
                          String[][] opponentsBeetle, Double purse, Double userBetAmount, Double opponentBet) {
        System.out.println();
        border();
        userHasPlacedABet(userBetAmount);
        opponentHasPlacedABet(opponentBet);
        currentPurse(purse);
        border();
        yourBeetleTitleLine();
        usersRollResults(userRollValue);
        drawPlayerBeetle(usersBeetle);
        border();
        opponentsBeetleTitleLine();
        opponentsRollResults(opponentsRollValue);
        drawPlayerBeetle(opponentsBeetle);
        border();
        System.out.println();
    }

}
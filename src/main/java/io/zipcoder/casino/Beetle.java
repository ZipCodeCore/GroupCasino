package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.awt.geom.Arc2D;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Beetle extends DiceGame{
    Console console;
    private InputStream in;
    private PrintStream out;
    Scanner scanner = new Scanner(System.in);
    BeetleDisplay bd = new BeetleDisplay();
    Player player1 = new Player("Shel", 100.00);

    private String[][] completeBeetle = new String[][]{{"\\","0","/"},
        {"⎛","|","⎞"},
        {"⎝","|","⎠"},
        {"/","⏝","\\"}
    };
    private String[][] usersBeetle = new String[][]{{" "," "," "},
            {" "," "," "},
            {" "," "," "},
            {" "," "," "}
    };
    private String[][] opponentsBeetle = new String[][]{{" "," "," "},
        {" "," "," "},
        {" "," "," "},
        {" "," "," "}
    };

    private Set<Integer> usersRolls = new HashSet<Integer>();
    private Set<Integer> opponentsRolls = new HashSet<Integer>();
    private Double purse = 0.00;

    public Beetle() {
        this.in = System.in;
        this.out = System.out;
        this.console = new Console(in, out);

    }
    
    //if opponent set is equal to or greater than user set opponent will bet.
    
    //facilitator
    public void gameEngine() {
        Boolean userHasNotWon = true;
        Boolean opponentHasNotWon = true;
        Boolean playersHaveNotTied = true;

        acceptBetFromUser(1.00);
        acceptBetFrom();
        bd.currentPurse(purse);

        while (playersHaveNotTied && userHasNotWon && opponentHasNotWon) {
            //current purse amount
            Double betAmount = (console.getDoubleInput("how much would you like to bet?"));
            acceptBetFromUser(betAmount);
            if (opponentsRolls.size() >= usersRolls.size()) {
                Double opponentBet = acceptBetFrom();
                bd.opponentHasPlacedABet(opponentBet);
            }

            bd.border();
            bd.currentPurse(purse);

            Integer userRollValue = diceRollSum(1);
            bd.usersRollResults(userRollValue);
            analyzeRoll(usersRolls, usersBeetle, userRollValue);
            drawPlayerBeetle(usersBeetle);
            bd.border();

            Integer opponentsRollValue = diceRollSum(1);
            bd.opponentsRollResults(opponentsRollValue);
            analyzeRoll(opponentsRolls, opponentsBeetle, opponentsRollValue);
            drawPlayerBeetle(opponentsBeetle);
            bd.border();

            if (Arrays.deepEquals(completeBeetle, usersBeetle) && Arrays.deepEquals(completeBeetle, opponentsBeetle)) {
                playersHaveNotTied = false;
                bd.bothBeetlesComplete();
                player1.setWallet(player1.getCurrentBet());
                System.out.println("Your bets were returned to your wallet.");
                break;
            } else if (Arrays.deepEquals(completeBeetle, usersBeetle)) {
                userHasNotWon = false;
                bd.userBugIsComplete();
                player1.setWallet(purse);
                player1.setCurrentBet(0.00);
                break;
            } else if (Arrays.deepEquals(completeBeetle, opponentsBeetle)) {
                opponentHasNotWon = false;
                bd.opponentsBugisComplete();
                player1.setWallet(-player1.getCurrentBet());
                player1.setCurrentBet(0.00);
                break;
            }
        }
        System.out.println(player1.getWallet());

    }


    public void analyzeRoll(Set<Integer> rollSet, String[][] playersBeetle, Integer diceRoll){
        if(!rollSet.contains(diceRoll)) {
            drawBeetle(rollSet, playersBeetle,diceRoll);
            rollSet.add(diceRoll);
        }
        else {
                bd.repeatedRollResult();
            }
    }

    public void drawBeetle(Set rollSet, String[][] playersBeetle, Integer diceRoll) {

        switch (diceRoll) {
            case 1:
                bd.drewLeg();
                playersBeetle[0][0] = completeBeetle[0][0];
                break;
            case 2:
                bd.drewLeg();
                playersBeetle[0][2] = completeBeetle[0][2];
                break;
            case 3:
                bd.drewLeg();
                playersBeetle[3][0] = completeBeetle[3][0];
                break;
            case 4:
                bd.drewLeg();
                playersBeetle[3][2] = completeBeetle[3][2];
                break;
            case 5:
                bd.drewHead();
                playersBeetle[0][1] = completeBeetle[0][1];
                playersBeetle[1][1] = completeBeetle[1][1];
                playersBeetle[2][1] = completeBeetle[2][1];
                break;
            case 6:
                bd.drewBody();
                playersBeetle[1][0] = completeBeetle[1][0];
                playersBeetle[1][2] = completeBeetle[1][2];
                playersBeetle[2][0] = completeBeetle[2][0];
                playersBeetle[2][2] = completeBeetle[2][2];
                playersBeetle[3][1] = completeBeetle[3][1];

                break;
            default:
                System.out.println("something went wrong");
                break;
        }
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


    public void opponentBet() {

    }

    public Set<Integer> getUsersRolls() {
        return usersRolls;
    }

    public Set<Integer> getOpponentsRolls() {
        return opponentsRolls;
    }

    public String[][] getUsersBeetle(){
        return usersBeetle;
    }

    public String[][] getOpponentsBeetle(){
        return opponentsBeetle;
    }

    public String[][] getCompleteBeetle(){
        return completeBeetle;
    }




    public String startGame() {
        return null;
    }

    public Double acceptBetFrom(Double betAmount) {
        return null;
    }

    public Double acceptBetFrom() {
        Double betAmount = 1.00;
        purse += betAmount;
        return betAmount;
    }

    public void acceptBetFromUser(Double betAmount) {
        player1.makeBet(betAmount);
        purse += betAmount;
    }

    public Double calculateReward() {
        double reward = purse - player1.getCurrentBet();

        return reward;
    }

    public Double calculateLoss() {
        return player1.getCurrentBet();
    }

    public String endGame() {
        return null;
    }
}

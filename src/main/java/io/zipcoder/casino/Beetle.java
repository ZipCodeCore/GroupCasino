package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

public class Beetle extends DiceGame{
    Player player;
    Random random = new Random();
    Console console;
    private InputStream in;
    private PrintStream out;
    BeetleDisplay bd = new BeetleDisplay();
    NumberFormat nf = NumberFormat.getCurrencyInstance();

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

    public Beetle(Player player) {
        this.player = player;
        this.in = System.in;
        this.out = System.out;
        this.console = new Console(in, out);
    }
    
// FACILITATOR
    public void gameEngine() {
        Boolean userHasNotWon = true;
        Boolean opponentHasNotWon = true;
        Boolean playersHaveNotTied = true;

        displayWelcomeSequence();
        tableMinimumDeposit();
        bd.currentPurse(getPurse());
        while (playersHaveNotTied && userHasNotWon && opponentHasNotWon) {

            //BET
            Double userBetAmount = (console.getDoubleInput("how much would you like to bet?"));
            acceptBetFromUser(userBetAmount);
            Double opponentBet = opponentBet(userBetAmount);
            acceptBetFrom(opponentBet);

            //PLAY
            Integer userRollValue = diceRollSum(1);
            analyzeRoll(usersRolls, usersBeetle, userRollValue);
            Integer opponentsRollValue = diceRollSum(1);
            analyzeRoll(opponentsRolls, opponentsBeetle, opponentsRollValue);

            //DISPLAY
            bd.gameBoard(userRollValue, usersBeetle, opponentsRollValue, opponentsBeetle, getPurse(),userBetAmount,opponentBet);

            //ANALYZE
            playersHaveNotTied = tieStateDoesNotExist(usersBeetle, opponentsBeetle);
            userHasNotWon = winningStateDoesNotExist(usersBeetle);
            opponentHasNotWon = losingStateDoesNotExist(opponentsBeetle);
        }
        bd.printAccountBalance(player.getWallet());
    }

    public Double opponentBet(Double userBet) {
        Double opponentBet = 0.0;
        if (opponentsRolls.size() >= usersRolls.size()) {
            Double multiplier = random.nextDouble() + 0.5;
            opponentBet = userBet * Math.round(multiplier * 100) / 100;
        }
        BigDecimal formattedBet = new BigDecimal(opponentBet).setScale(2, RoundingMode.HALF_UP);
        opponentBet = formattedBet.doubleValue();
        return opponentBet;
    }

    //GAME STATE
    public Boolean tieStateDoesNotExist(String[][] usersBeetle, String[][] opponentsBeetle) {
        if (Arrays.deepEquals(completeBeetle, usersBeetle) && Arrays.deepEquals(completeBeetle, opponentsBeetle)) {
            bd.bothBeetlesComplete();
            player.setWallet(player.getCurrentBet());
            System.out.println("Your bets were returned to your wallet.");
            return false;
        }
        return true;
    }

    public Boolean winningStateDoesNotExist(String[][] usersBeetle) {
        if (Arrays.deepEquals(completeBeetle, usersBeetle)) {
            bd.userBugIsComplete();
            player.setWallet(purse);
            player.setCurrentBet(0.00);
            return false;
        }
        return true;
    }

    public Boolean losingStateDoesNotExist(String[][] opponentsBeetle) {
        if (Arrays.deepEquals(completeBeetle, opponentsBeetle)) {
            bd.opponentsBugisComplete();
            player.setWallet(-player.getCurrentBet());
            player.setCurrentBet(0.00);
            return false;
        }
        return true;
    }

    public void displayWelcomeSequence() {
        bd.welcome(player.getName());
        drawPlayerBeetle(getCompleteBeetle());
        bd.rules();
    }


    public void analyzeRoll(Set<Integer> rollSet, String[][] playersBeetle, Integer diceRoll){
        if(!rollSet.contains(diceRoll)) {
            updateBeetleDrawing(playersBeetle,diceRoll);
            rollSet.add(diceRoll);
        }
    }


    public void updateBeetleDrawing(String[][] playersBeetle, Integer diceRoll) {

        switch (diceRoll) {
            case 1:
                playersBeetle[0][0] = completeBeetle[0][0];
                break;

            case 2:
                playersBeetle[0][2] = completeBeetle[0][2];
                break;

            case 3:
                playersBeetle[3][0] = completeBeetle[3][0];
                break;

            case 4:
                playersBeetle[3][2] = completeBeetle[3][2];
                break;

            case 5:
                playersBeetle[0][1] = completeBeetle[0][1];
                playersBeetle[1][1] = completeBeetle[1][1];
                playersBeetle[2][1] = completeBeetle[2][1];
                break;

            case 6:
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


    public void acceptBetFromUser(Double betAmount) {
        player.makeBet(betAmount);
        purse += betAmount;
    }


    public Double tableMinimumDeposit() {
        acceptBetFromUser(1.00);
        purse += 1;
        return purse;
    }


    public Double calculateReward() {
        double reward = purse - player.getCurrentBet();
        return reward;
    }


    public Double calculateLoss() {
        return player.getCurrentBet();
    }


    //GETTERS AND SETTERS
    public Double getPurse() {
        BigDecimal purseFormatted = new BigDecimal(purse).setScale(2, RoundingMode.HALF_UP);
        purse = purseFormatted.doubleValue();
        return purse;
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

    //FROM ABSTRACT CLASSES
    public String endGame() {
        return null;
    }

    public String startGame() {
        return null;
    }

    public Double acceptBetFrom(Double betAmount) {
        purse += betAmount;
        return purse;
    }
}
